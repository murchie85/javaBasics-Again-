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
