### Design Document: Sign-Up, Login & Protected API Access using Headers
**Objective**
- **Design a system where:**
  - On sign-up, a user is registered in the database.
  - On login, a header (token) is returned.
  - User can call protected APIs only if this header is sent and validated.
  - Header validation happens on each protected API call to ensure secure access.

**Components Overview**
- **2.1. APIs**
  - POST /signup: Register user in the database.
  - POST /login: Authenticate user, return header token.
  - GET /protected-resource: Accessible only with a valid token in the header.
  - Middleware (Auth Filter): Intercepts protected routes to validate the token from the header before processing the request.

**Database Design**
- **Users Table**
  - id: PK, UUID/Auto Increment
  - username or email: UNIQUE
  - hashed_password: Store hashed password using BCrypt/Argon2
  - created_at, updated_at
  - (Optional) Token Blacklist Table
  - If using JWT without expiration enforcement, you may add a token blacklist for logout or forced invalidation.

### Design Steps 

---
**Step-1: User Sign-Up**
- **What is the purpose?**
  - To register a new user so that:
  - We know who the user is.
  - We can store their credentials securely.
  - They can later log in and access protected resources.

**What happens in this step?**
  - **User sends data**
  - The user will open your app or Postman and send:
  - email (or username) – to identify them uniquely.
  - password – for authentication.

**Example:**
```
{
"email": "student@example.com",
"password": "StrongPassword@123"
}
```
- They will send this to your API endpoint: POST /signup .

**Input validation**
 - Before doing anything:
 - Check if email is in a valid format. 
 - Check if password is strong enough (min length, includes letters/numbers/special chars).
 - Check if email already exists in your database to prevent duplicates.

**What does input validation mean?**
- Before processing user data, check if the input meets your rules.

  **Why?**
  - To avoid bad data in your system and reduce issues later.
  - Prevents bad/garbage data entering your system.
  - Reduces bugs later when you use the data.
  - Protects against basic attacks (e.g., invalid inputs, script injections in fields).
    
**What checks to do during sign-up?**
- **Email Validation:**
  - Check format: e.g., ```student@example.com.```
  - Use regex or built-in validators:
    - Java: Pattern.compile ```("^[A-Za-z0-9+_.-]+@(.+)$")```
    - Spring Boot: ```@Email annotation.```

- **Password Validation:**
  - Check minimum length (e.g., at least 8 characters).
  - Check for uppercase, lowercase, number, special character.
  - Optionally check for no spaces.

- **Check if Email Already Exists:**
  - Query the ```Users``` table:
  - ```SELECT * FROM Users WHERE email = 'student@example.com';```
  - If exists, return:
  - ```{ "error": "Email already registered"}```
  - With 400 Bad Request.

**How does this work internally?**
- At controller/service level:
  - Receive JSON request → parse to DTO object.
  - Run validations using:
    - Manual checks (```if password.length() < 8```).
    - Framework validators (e.g., Spring’s ```@Valid```, ```@Email```, ```@Size```). 
  - Return errors immediately if validation fails.

**Hash the password**
 - We never store plain text passwords in the database.
 - We will: Use a hashing algorithm like BCrypt.
 - Hash the password with a salt (BCrypt does this automatically).

**Example:**
```String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());```

**Why do we hash passwords?**
- If your DB is hacked, attackers cannot see real passwords.
- Hashing is one-way (you can’t get back the original password).
- Passwords are verified by hashing the input and comparing hashes.

**How does BCrypt work internally?**
- BCrypt is a password hashing function designed to:
- Be computationally expensive (slow on purpose).
- Use a salt automatically (a random value added to prevent identical passwords having the same hash).

**Hashing process with BCrypt:**
- **Salt Generation:**
  - BCrypt generates a random salt (e.g., 128 bits).
  - Salt is embedded inside the final hash string.

- **Hashing:**
  - The password + salt are processed with Eksblowfish cipher internally.
  - A work factor (cost factor) determines the computational cost (e.g., 10 → 2^10 iterations).

- **Output:** 
  - A 60-character string: ```$2a$10$eImiTXuWVxfM37uY4JANjQ== hash==```
  - $2a$ → algorithm
  - 10 → cost factor
  - next 22 chars → salt
  - remaining → hashed password.

**During verification:**
  - BCrypt extracts the salt from the stored hash. 
  - Hashes the entered password with the same salt. 
  - Compares the computed hash with the stored hash. 
  - If equal → password is correct.
  - **Example:** BCrypt in Java
    Using BCrypt library: 
    ```
    // Hashing
    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    
    // Verification
    boolean matches = BCrypt.checkpw(enteredPassword, hashedPassword);
    ```

**Why do we hash passwords, not use other processes?**
- **What alternatives could someone think of?**
  - Store passwords as plain text
  - Encrypt passwords (using AES, etc.)
  - Hash passwords (BCrypt, PBKDF2, Argon2) .

**Why not store plain text?**
  - If your database is hacked, all user passwords are leaked instantly.
  - It is a serious security vulnerability.
  - Users often reuse passwords across sites → high risk.

**Why not encrypt passwords with AES or symmetric encryption?**
  - Encryption allows decryption with a key.
  - If your encryption key is leaked, all passwords can be decrypted.
  - Encryption is reversible, but for passwords, we do not need reversibility.

**Why hashing is the right approach?**
  - **Hashing is one-way:**
    - You cannot get back the original password from its hash.
  - **Verification is still possible:**
    - User sends their password → you hash it → compare it with the stored hash.
    - If hashes match → the password is correct.
  - **Adding salt:**
    - Prevents two users with the same password from having the same hash.
    - Prevents precomputed attacks (rainbow tables).
  - **Using slow hashing (BCrypt, Argon2):**
    - Makes brute-force attacks impractical.
    - Fast hashing algorithms like SHA-256 are not secure for passwords since attackers can try billions of combinations per second.
    - Slow hashes force attackers to take much longer per guess.

- Hashing is the industry standard for password storage because we only need to verify, not recover passwords.

**Send a response**
- Once stored successfully, respond to the user: 201 Created
- With a message: ```{"message": "User registered successfully"}```

**Why do we do these steps?**
- Validate input : To avoid garbage data
- Hash password : To protect user security 
- Store in DB : To track registered users
- Send response : To confirm registration

**What if the user tries to sign up with the same email again?**
- Return: 400 Bad Request
- Message: "Email already registered"
- Because: Emails should be unique to identify users clearly.

---

---
### Step 2: User Login
**What is the purpose?**
- Allow a registered user to log in securely so they can:
  - Prove they are the real owner of the account.
  - Receive a header token (JWT) to access protected APIs.

**What happens in this step?**
- User sends credentials
  - The user sends: email (or username) and password
  - **Example :** 
  ```
  { "email": "student@example.com", 
        "password": "MyStrongPassword123"
  }
  ```
- To your endpoint: POST /login

**Find the user in the database**
- You will: Search the Users table for the provided email.
  - **Example:** ```SELECT * FROM Users WHERE email = 'student@example.com';```
- **If user not found:** Return: ```{"error": "Invalid credentials"}```
- With 401 Unauthorized.

**Verify the password using BCrypt**
- Retrieve the hashed password stored in the DB.
- Use BCrypt’s check function to compare the entered password with the stored hash.
- Example in Java: ```boolean matches = BCrypt.checkpw(enteredPassword, storedHashedPassword);```
- If it does not match:
  - Return 401 Unauthorized with "Invalid credentials".
- If it matches:
  - The user is authenticated.

**Generate a JWT (JSON Web Token)**
- Now you create a token to return to the user so:
  - They can access protected APIs without logging in each time.
  - The server can verify user identity statelessly.

**What is JWT?**
- A compact, URL-safe token for securely transmitting information between parties.
- Contains claims like userId, email, iat (issued at), exp (expiry).
- Signed using your server secret key, so it cannot be tampered with.
- Used for authentication and authorization in stateless APIs.

**How to implement JWT practically?**
- **Decide secret key**
  - Keep it long, random, and secure.
  - Used to sign and verify JWTs.

**How does JWT work internally?**
**Example JWT payload:**
```
{
  "userId": "123e4567-e89b-12d3-a456-426614174000",
  "email": "student@example.com"
}
```

**JWT Structure:**
- header.payload.signature

**Example:**
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxMjM0IiwiaWF0IjoxNzIwODAwLCJleHAiOjE3MjA4MDAwfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

**What’s inside each part?**
- Header
- Specifies: The signing algorithm (alg: e.g., HS256).
  - The token type (typ: JWT). 
  - Example : 
```
{
"alg": "HS256",
"typ": "JWT"
}
```
- Payload
- Contains claims (information you want to include):
  - userId, email, role, etc.
  - iat (issued at)
  - exp (expiry timestamp)

- Signature 
- Used to verify integrity and authenticity.
- Uses your server secret key to sign.
- Ensures nobody can modify the payload or header without invalidating the signature.

**Example Workflow of JWT in your system:**
- **On login:**
 - User sends email, password.
 - Server verifies credentials.
 - Server generates JWT:
 - Includes user ID, issued time, expiry.
 - Signs it using secret key.
 - Server returns JWT in: ```Authorization: Bearer <jwt-token>```
 - Client stores the JWT securely (in memory/local storage).

- **On protected API call:**
 - **Client sends:** ```Authorization: Bearer <jwt-token>```
 - Server extracts JWT:
   - Splits into header, payload, signature.
   - Verifies signature using the secret key.
   - Checks exp claim for expiry.
- **If valid:**
  - Extracts userId and allows access.
- **If invalid:**
  - Returns 401 Unauthorized.

**Return the JWT in the Authorization header**
- In your response: ```Authorization: Bearer <JWT_TOKEN>```
- and in the body: ```{ "message": "Login successful"}```
- The user stores this token (in frontend memory/local storage) to use in subsequent protected API calls.

**Why do we return a JWT on login?**
- Allows stateless authentication (no server session storage).
- Each protected API call will:
  - Extract the token.
  - Verify its signature and expiry.
  - Allow access if valid.
- Enhances scalability for microservices and distributed systems.
- JWT = Header + Payload + Signature.

**What if the token is stolen?**
- If someone gets your JWT:
  -  They can access APIs until the token expires.
  - Mitigation:
    - Use HTTPS to prevent token interception.
    - Use short-lived tokens (e.g., 15-30 min).
    - Optionally use refresh tokens for re-authentication.

**Why is this approach important?**
- Securely authenticates the user.
- Eliminates the need to store sessions on the server.
- Easily scales across distributed environments.
- Keeps APIs secure by requiring token validation on each call.

---

---
### Step 3: Protected API Access with JWT
**Purpose**
- Ensure only logged-in users (with valid JWT) can access protected endpoints like:
 - /profile
 - /orders
 - /admin
- Ensure user identity verification on every request without session storage on the server.

**What happens in this step?**
  - User sends a protected API request
  - After login, the client includes the JWT in the Authorization header:

**Example**
```
GET /profile
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```
**Server extracts the JWT**
- Your API will:
  - Read the Authorization header.
  - Check it starts with Bearer .
  - Extract the token string after Bearer .

**Server validates the JWT**
- The server will:
  - Split the JWT into header.payload.signature.
  - Use the secret key to:
    - Verify the signature.
    - Confirm token integrity.
  - Check expiry (exp claim).

- **Extract user information from JWT**
- Once validated, extract:
  - userId (claims.getSubject())
  - email (claims.get("email"))
  - role, etc. (if needed for authorization).
- Use this userId to:
 - Fetch user data from DB (if needed).
 - Allow user-specific operations.

- **Proceed with the protected action**
 - Your controller or service now safely executes the action, knowing:
   - The user is authenticated.
   - The user’s identity is confirmed.

  **Example:**
  - Return profile data.
  - Fetch orders.
  - Allow sensitive actions.


**Summary Workflow**
- Client:
 - Calls protected API with JWT in the header.

- Server:
  - Reads header.
  - Verifies JWT signature + expiry.
  - Extracts user details.
  - Executes the protected action.

- If invalid:
 - Respond with: ```{"error": "Unauthorized"}```
 - with 401 Unauthorized.

**Why is this step important?**
- Ensures API security.
- Confirms user authentication on every call.
- Enables stateless authentication, allowing scaling without session storage.

**What if JWT is expired?**
- The user must log in again to get a new JWT, OR
- Use a refresh token strategy to issue new tokens without forcing re-login.

---

---
### Step 4: Refresh Token Flow

**Solve the problem of JWT expiry:**
- Access tokens (JWT) are short-lived for security (e.g., 15–30 min).
- Without refresh tokens, the user must log in again when JWT expires.

- **Using a refresh token allows:**
- Issuing a new access token automatically without forcing re-login.
- Better user experience with maintained security.

**What is a Refresh Token?**
- A long-lived token (valid for days/weeks).
- Issued alongside the short-lived access token (JWT) during login.
- Stored securely on the client (HTTP-only cookie/local storage).
- Used only to get a new JWT when it expires.

**Refresh Token Workflow**
- **Login**
  - User logs in with email and password.
  - **Server issues:**
  - Access Token (JWT): valid for 15–30 min.
  - Refresh Token: valid for 7–30 days.

**Access Token Expiration**
- JWT expires after 30 min.
  - Client calls protected API, receives:
```
{
"error": "Token expired"
}
```
- with 401 Unauthorized.

**Refresh Token Used**
 - Client sends a request to:
```
POST /refresh-token
with:
{
"refreshToken": "<refresh_token>"
}
```
- OR as an HTTP-only secure cookie.

**Server Validates Refresh Token**
- Check:
 - Refresh token is valid.
 - Refresh token is not expired.
 - Refresh token is not revoked/blacklisted.
- **If valid:**
 - Generate a new JWT access token with fresh expiry.
 - Optionally issue a new refresh token.

- **Return:**
```
{
"accessToken": "<new_jwt_token>",
"refreshToken": "<new_refresh_token>" // if rotating refresh tokens
}
```

**Client Uses New Access Token**
- The user can now continue using protected APIs without re-logging in.

**Where do we store refresh tokens?**
 - Recommended: HTTP-only Secure Cookie:
 - Cannot be accessed by JavaScript → protects from XSS.
**Sent automatically on refresh requests.**
Alternatively: Encrypted local storage (less secure).

**Security Considerations**
- Refresh tokens are long-lived, so: Store securely (HTTP-only cookies).

- Use rotation:
- On each refresh, issue a new refresh token.
- Invalidate the old refresh token (store in DB or Redis for tracking).
- Allow manual revocation on logout or suspicious activity.


**Implementation Overview**
- On login:
 - Generate access token (JWT, 15–30 min expiry).
 - Generate refresh token (random UUID/token, 7–30 days expiry).
 - Store refresh token securely on the server (DB/Redis) with user ID.

**On /refresh-token:**
 - Accept refresh token.
 - Check in DB/Redis if: Exists ,Not expired ,Not revoked

**If valid:**
- Generate new JWT access token.
- Optionally generate a new refresh token (rotation).
- Return to the client.

---

---
### Logout & Token Revocation
- **Purpose**
- Allow the user to log out securely.
- Ensure tokens (access + refresh) can no longer be used after logout.
- Handle security incidents (token theft, suspicious activity) by revoking tokens.

**Why is logout/token revocation needed in JWT-based systems?**
- JWT is stateless: the server does not track issued tokens.
- By default, JWT remains valid until it expires, even if the user “logs out” from the client.

**We need mechanisms to invalidate tokens to:**
-  Protect user accounts.
-  Allow clean user logout.
-  Respond to suspected token compromise.

**Two strategies for Logout/Revocation**
1️-Access Token Only (Short-lived, Let It Expire)
  - If access tokens are short-lived (15–30 min):

**Logout can simply:**
- Remove token from client storage (localStorage/cookies).
- Inform the user they are logged out.
- Since the token expires soon, the window of misuse is small.

**Limitation:**
- If stolen, the attacker can use it until expiry.
- Access + Refresh Token Revocation (Recommended)
- For systems with refresh tokens:

**Revoke refresh tokens on logout so no new access tokens can be generated.**
- Refresh Token Revocation Workflow

- **On Login:**
  - Store the issued refresh token in your database/Redis linked with: userId ,refreshToken , expiry isRevoked (false)

- **On Logout:**
 - User calls:
```
POST /logout
Authorization: Bearer <access_token>
Body:
{
"refreshToken": "<refresh_token>"
}
```

**Server actions:**
- Extract user identity from access_token or refresh_token.
- Find the refresh token in DB/Redis.
 - Mark it as:
 - isRevoked = true
 - Or remove it entirely from storage.
- Optionally invalidate cookies on the client.

**Respond:**
```
{
"message": "Logout successful"
}
```

**Now:**
- The revoked refresh token cannot be used to generate new access tokens.
- User must re-login to get new tokens.

**Handling stolen tokens: Blacklisting**
- For high-security systems, you may:
- Maintain a blacklist of revoked access tokens until they expire.

**On each API call:**
- Check if the access_token is in the blacklist.
- Deny access if blacklisted.

**Tradeoff:**
- Adds state and memory usage.
- Typically only used for sensitive systems due to overhead.

---

---



 











