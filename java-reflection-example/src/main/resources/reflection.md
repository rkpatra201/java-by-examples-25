### Reflection

- It allows to inspect and manipulate classes , method , constructor , interfaces , and fields at run time .
- In order to reflect a class we first need create an object of class . From the classes you can obtain information about.
- Class Name ,Class Modifies (public, private, synchronized etc.) ,Package Info ,Superclass ,Implemented Interfaces ,Constructors ,Methods ,Fields .
- There are different way to achieve this i.e
  - 1) Using .Class extension
  - 2) Using getClass() method
  - 3) Using forName() method

- The forName() method of java.lang.Class class is used to get the instance of this Class with the specified class name. 
- This class name is specified as the string parameter.
**Syntax :**
  - public static Class<T> forName(String className) throws ClassNotFoundException
  
**Example**

```
// class name using forName()
Cat cat = new Cat();
Class object1 = Class.forName("com.example.app.Cat");
System.out.println(object1);

//class :
class Cat extends Animal{
    public void skinColor(){
        System.out.println("my skin color is black");
    }
}

o/p : class com.example.app.Cat
```
### For Classes :
- getName() returns the name of the class 
- getModifiers() - returns the access modifier of the class in integer form 
- getSuperClass() - returns the superclass of the class 

### The Class Object :
- All types in Java including the primitive types (int, long, float etc.) including arrays have an associated Class object.
- If you don't know the name at compile time, but have the class name as a string at runtime, you can do like this:
- String className = ... //obtain class name as string at runtime Class class = Class.forName(className);
- When using the Class.forName() method you must supply the fully qualified class name.
- The Class.forName() method may throw a ClassNotFoundException if the class cannot be found on the classpath at runtime.

**Modifiers :**
- You can access the modifiers of a class via the Class object. 
- The class modifiers are the keywords "public", "private", "static" etc. You obtain the class modifiers like this:

**Example**
```java
package com.example.app;

import java.lang.reflect.Modifier;

// get access modifier of the class
public class App3 {
  public static void main(String[] args) {
    UtkalUniversity university = new UtkalUniversity();
    Class institute = UtkalUniversity.class;
    int modifier = institute.getModifiers();
    System.out.println(Modifier.toString(modifier));
  }
}
class Institute{
  public void university(){
    System.out.println("UGC");
  }
}

package com.example.app;

public class UtkalUniversity extends Institute {
  public void subUniversity() {
    System.out.println("utkal university is under ugc ");
  }
}

// 0/p : public
```
### Implemented Interfaces
- A class can implement many interfaces. Therefore an array of Class is returned. 
- Interfaces are also represented by Class objects in Java Reflection.

**Note**
- Only the interfaces specifically declared implemented by a given class is returned
-  If a superclass of the class implements an interface, but the class doesn't specifically state that it also implements that interface, that interface will not be returned in the array.
- Even if the class in practice implements that interface, because the superclass does.

**Example**
```
package com.example.app;

import java.lang.reflect.Method;

public class App4 {
    public static void main(String[] args) {
        PublicRight publicRight = new PublicRight();
        Class implementedInterface = PublicRight.class;
        Class[] interfaces = implementedInterface.getInterfaces();
        for (Class interface1 : interfaces){
            System.out.println(interface1.getName());
        }

    }
}
interface Vehicle{
}
interface Institution{
}
interface Constitution{
}
class PublicRight implements Vehicle,Institution,Constitution{

}

// o/p : 
com.example.app.Vehicle
com.example.app.Institution
com.example.app.Constitution
```

**Constructors**
- can access the constructors of a class like 

**Example**
```
package com.example.app;

import java.lang.reflect.Constructor;

// constructor inspection example
public class App5 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Class constructor = Bike.class ;

        Constructor[] constructors = constructor.getConstructors();
        for (Constructor constructor1 : constructors){
            System.out.println(constructor1);
        }
    }
}
class Bike{

    public String name ;
    public String colour ;
    public int gear ;

    public Bike() {
    }

    public Bike(String name){

    }
    public Bike(String name , String colour){

    }

    public Bike(String name, String colour, int gear) {
        this.name = name;
        this.colour = colour;
        this.gear = gear;
    }
}

o/p : 
public com.example.app.Bike(java.lang.String,java.lang.String,int)
public com.example.app.Bike(java.lang.String,java.lang.String)
public com.example.app.Bike(java.lang.String)
public com.example.app.Bike()
```
### Obtaining Field Objects
- The Field[] array will have one Field instance for each public field declared in the class.
- Once you have obtained a Field instance, you can get its field name using the Field.getName() method.
- You can determine the field type (String, int etc.) of a field using the Field.getType() method.
- Once you have obtained a Field reference you can get and set its values using the Field.get() and Field.set()methods.
- It the field is a static field (public static ...) pass null as parameter to the get and set methods.

**Example**
```
package com.example.app;

import java.lang.reflect.Field;

public class App6 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyClass myClass = new MyClass();
        Class field = MyClass.class ;

        // access field
        Field field1 = field.getField("num1");
        System.out.println(field1);

        // field name
        String field2 = field.getName();
        System.out.println(field2);

        // get field
        Object value = field1.get(myClass);
        System.out.println(value);

        // set field
        field1.set(myClass , 11);

    }
}

class MyClass{
    public int num1 = 10 ;
    String name = "Biswajit";
}

o/p :
public int com.example.app.MyClass.num1
com.example.app.MyClass
10

```

### Getters and Setters
- Using Java Reflection you can inspect the methods of classes and invoke them at runtime.
- This can be used to detect what getters and setters a given Java class has.
- Getter :A getter method have its name start with "get", take 0 parameters, and returns a value.
- Setter :A setter method have its name start with "set", and takes 1 parameter.
- Setters may or may not return a value.
- Some setters return void, some the value set, others the object the setter were called on for use in method chaining.

```
package com.example.app;

import java.lang.reflect.Method;

public class App7 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Method[] methods = employee.getClass().getMethods();
        for (Method method : methods){
            if(isGetter(method)) System.out.println("getter: " + method);
            if(isSetter(method)) System.out.println("setter: " + method);
        }
    }
    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))
            return false;
        if(method.getParameterTypes().length != 0)
            return false;
        if(void.class.equals(method.getReturnType()))
           return false;
        return true;
    }
    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }
}
class Employee{
    public String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

o/p :
getter: public java.lang.String com.example.app.Employee.getName()
setter: public void com.example.app.Employee.setName(java.lang.String)
getter: public final native java.lang.Class java.lang.Object.getClass()
```

### What are Java Annotations?
- Java annotations are used to provide meta data for your Java code
- Being meta data, Java annotations do not directly affect the execution of your code, although some types of annotations can actually be used for that purpose.
- Java annotations are typically used for : Compiler instructions , Build-time instructions , Runtime instructions .
- The build process includes generating source code, compiling the source, generating XML files (e.g. deployment descriptors), packaging the compiled code and files into a JAR file etc. 
- Building the software is typically done by an automatic build tool like Apache Ant or Apache Maven.

**Accessing Java Annotations via Java Reflection**
- Java annotations are not present in your Java code after compilation.
- It is possible, however, to define your own annotations that are available at runtime. 
- These annotations can then be accessed via Java Reflection, and used to give instructions to your program, or some third party API.

**Class Annotations**
- You can access the annotations of a class, method or field at runtime.
```
package com.example.app;

import java.lang.annotation.*;

// This annotation specifies how long annotations are retained.
// RUNTIME means the annotation is available during runtime for reflection.
@Retention(RetentionPolicy.RUNTIME)

// Specifies where the annotation can be applied. ElementType.TYPE means it can be applied to classes, interfaces, enums.
@Target(ElementType.TYPE)

// My custom annotation
@interface MyAnnotation {
public String name();
public String value();
}

// Class Annotation example
@MyAnnotation(name = "Biswajit", value = "Java Developer")
public class App8 {
public static void main(String[] args) {
Class aClass = App8.class;
Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}

o/p : 
name: Biswajit
value: Java Developer
```

**Method Annotations**
- You can access the annotations of a method at runtime.
**Example**
```
package com.example.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class TheClass {
    @MyAnnotation(name="helloAnnotation",  value = "Hello World")
    public void helloAnnotation(){}
}
// method annotation example
public class App9 {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TheClass.class.getMethod("helloAnnotation");
        Annotation[] annotations = method.getDeclaredAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}

o/p :
name: helloAnnotation
value: Hello World
```