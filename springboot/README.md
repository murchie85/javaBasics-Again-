# Spring Boot


## SPRING BOOT LOG PROJECT
  
- [springboot_logapp](https://github.com/murchie85/springboot_logapp)

# Spring Specifics

## Externalised Configuration  

If using application.yml or other config, key names should always be kebab case
```yaml
- first-name-basis
```

At runtime this will inject the key values as camel case i.e. `firstNameBasis`

More documentation here 

https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/boot-features-external-config.html




# Spring Boot 


# @Configuration

`@Configuration` annotation is used to define a class as a configuration class, which contains bean definitions and configurations. It is equivalent to an XML-based configuration in a Spring application.

```java
// Example of a @Configuration class
@Configuration
public class AppConfig {
    // Define a bean
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

# @Getter and @Setter

@Getter and @Setter are annotations from Project Lombok, which help to reduce boilerplate code. They automatically generate getter and setter methods for fields in a class.

```java
// Example of a class with @Getter and @Setter annotations
@Getter
@Setter
public class Employee {
    private String name;
    private int age;
}

```  

In this example, Lombok will generate the following methods:

- `public String getName()`
- `public void setName(String name)`
- `public int getAge()`
- `public void setAge(int age)`


You can access with 

```java
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Bob");

        System.out.println("Name is : " + employee.getName());
    }
}
```    

# @ConfigurationProperties

`@ConfigurationProperties` annotation binds external configuration properties (from .yml or .properties files) to a Java class. The prefix attribute specifies the prefix of the property keys.  

```yaml
# application.yml
mySpecialApplicationValue:
  name: John Doe
  age: 30
```

```java
// Example of a class with @ConfigurationProperties
@ConfigurationProperties(prefix = "mySpecialApplicationValue")
@Getter
@Setter
public class MyValueProperties {
    private String name;
    private int age;
}
```


To use these annotations in a Spring Boot application:

1. Create a Spring Boot application.

2. Add Lombok to your project's dependencies:

```xml
<!-- pom.xml -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>provided</scope>
</dependency>

```

3. Enable annotation processing in your IDE for Lombok to work properly.

4. Create the classes and add the annotations as shown in the examples above.

5. To use the generated getters, you can simply call them on an instance of the class.

```java
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Alice");
        employee.setAge(25);

        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Age: " + employee.getAge());
    }
}

```

6. To use the @ConfigurationProperties class, you need to register it as a bean in your configuration class or use @EnableConfigurationProperties:

```java
@Configuration
@EnableConfigurationProperties(MyValueProperties.class)
public class AppConfig {
}

```  

7. Now you can inject the `MyValueProperties` bean into any other class and access the properties using the generated getters:

```java
@Service
public class MyService {
    private final MyValueProperties myValueProperties;

    public MyService(MyValueProperties myValueProperties) {
        this.myValueProperties = myValueProperties;
    }

    public void printMyValues() {
        System.out.println("MyValue name: " + myValueProperties.getName());
        System.out.println("MyValue age: " + myValueProperties.getAge());
    }
}

```



# @EnableAsync 

is an annotation in Spring Framework that enables asynchronous processing using @Async on methods within the application. It tells Spring to create a proxy of the bean, so when an @Async method is called, it will be executed in a separate thread. Spring uses a TaskExecutor to manage these threads.
