package com.example.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class JWTUtil {
    private static final String SECRET = "secret_key";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    private static final long expiration_time = 1  * 60 * 1000; //5 minutes

    private static final Logger logger = Logger.getLogger(JWTUtil.class.getName());

    public static String generateToken(String username){

        logger.info("Token generated for Username: "+ username );
        return JWT.create().withSubject(username).withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() +expiration_time))
                .sign(algorithm);
    }

    public static boolean validateToken(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            System.out.println("token verification status - "+true);
            return true;
        }
        catch (TokenExpiredException e) {
            System.out.println("Token has been expired.");
            throw new ApiException("Expired token", "TOKEN_EXPIRED", 401);
        }
        catch (JWTVerificationException e) {
            System.out.println("Token is invalid..");
            throw new ApiException("Invalid token","TOKEN_INVALID",401);

        }
    }
    public static String getUsername(String token){
        DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
        return jwt.getSubject();
    }
}
