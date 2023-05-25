# MOCKITO Testing framework


## Ensure Mockito dependencies


### 1. Add Dependencies

You need to add Spring Boot Test and Mockito dependencies in your `pom.xml` (assuming you're using Maven):

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.5.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 2. Create a Service to Test

Create a simple service to illustrate how to write tests. For example, consider the following `GreetingService`:

```java
@Service
public class GreetingService {

    public String greet() {
        return "Hello, World";
    }
}
```

### 3. Writing Test

Next, we'll create a test for the `GreetingService`:

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingServiceTest {

    @Mock
    GreetingService greetingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGreet() {
        when(greetingService.greet()).thenReturn("Hello, Mock");

        String result = greetingService.greet();
        assertEquals("Hello, Mock", result);
    }
}
```

Here's what's happening in the test:

- `@RunWith(SpringRunner.class)`: This is a JUnit annotation. It tells JUnit to run the test with Spring's testing support. SpringRunner is the new name for SpringJUnit4ClassRunner in Spring 5.

- `@SpringBootTest`: This annotation tells Spring Boot to look for a main configuration class (a class annotated with `@SpringBootApplication`, for instance) and use it to start a Spring application context.

- `@Mock`: We're using this annotation to create a mock implementation of the `GreetingService`.

- `@BeforeEach`: This annotation is used to signal that the annotated method should be executed before each test. It's the equivalent of JUnit 4's `@Before`.

- `MockitoAnnotations.initMocks(this)`: Initializes objects annotated with `@Mock`, so Mockito can populate the mocked instances.

- `when(greetingService.greet()).thenReturn("Hello, Mock")`: We're stubbing the `greet` method of the mock `greetingService` instance to return `"Hello, Mock"`.

- The `testGreet` method tests if `greet` method returns `"Hello, Mock"`.

### 4. Verify Interactions

Mockito also provides a way to check if certain methods were called with certain parameters on the mock objects. This is done using the `verify` method. Here's an example:

```java
@Test
public void testGreet() {
    when(greetingService.greet()).thenReturn("Hello, Mock");

    String result = greetingService.greet();
    assertEquals("Hello, Mock", result);

    verify(greetingService).greet();
}
```

This ensures that the `greet()` method on `greetingService` was called exactly once.

And that's a basic Mockito test in a Spring Boot application! There's much more to learn about Mockito, like `@Spy`, `ArgumentCaptor`, and more, but this should get you started. Mockito's official documentation is a great resource for further learning.



A spy is an extension of the mock concept but comes into play when the actual functionality of the object needs to be used.

Let's start with a simple `Calculator` class that we will test using Mockito:

```java
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
```

Now, suppose you want to mock only the `multiply()` method and not the `sum()` method. Here, `@Spy` annotation comes into play:

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

    @Spy
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSum() {
        int result = calculator.sum(10, 20);
        assertEquals(30, result);
    }

    @Test
    public void testMultiply() {
        when(calculator.multiply(anyInt(), anyInt())).thenReturn(100);
        
        int result = calculator.multiply(10, 20);
        assertEquals(100, result);
        
        verify(calculator).multiply(10, 20);
    }
}
```

Let's see what's happening in the test:

1. `@Spy`: We're using this annotation to create a spy of the `Calculator` class. The spy calls the real methods of the class unless they're explicitly stubbed.

2. `@BeforeEach`: This annotation is used to signal that the annotated method should be executed before each test. It's the equivalent of JUnit 4's `@Before`.

3. `MockitoAnnotations.initMocks(this)`: Initializes objects annotated with `@Mock` or `@Spy`, so Mockito can populate the mocked instances.

4. `testSum()`: In this method, we're testing the actual `sum` method of the `Calculator` class. The `sum` method isn't stubbed, so it performs the actual calculation and returns the sum.

5. `testMultiply()`: In this method, we're stubbing the `multiply` method to return 100 regardless of the input. We then call the `multiply` method and verify that it returns the stubbed value (100). Finally, we use the `verify` method to ensure that `multiply` was called with the expected parameters.

The main takeaway is that spies allow partial mocking. The real methods are invoked unless they're explicitly stubbed.

Another point to note is that while using a spy, you have to be careful that the real methods you are not stubbing do not interact with any unwanted resources like a database or an external service. Mockito does not control the execution of the real method in the spy object, and this could lead to unexpected results if the code has side-effects.

Lastly, remember that while spies can be useful, overuse of spying could be a sign of poor design, as it might be an indicator that the responsibilities of the class under test aren't well-defined. It's usually better to refactor the class to more clearly separate its responsibilities.