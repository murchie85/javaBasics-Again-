# Utils and Common Functions


## Enums  

```java
// Java Enums are a type of data structure that allow you to define a set of named constants.
public enum LogLevel {
    DEBUG, // Constant values are defined within the Enum class and are simply named values that represent different levels of severity for a logging system.
    INFO,
    WARN,
    ERROR,
    FATAL
}

// Once you've defined your Enum, you can use it to represent log levels in your application.
public class Logger {
    public void log(LogLevel level, String message) {
        // Log the message at the appropriate severity level
    }
}

// Enums in Java are implemented as classes, and each constant value defined in the enum is an instance of that class.
// However, you do not need to interact with these instances directly in most cases.
// Instead, you can simply refer to the constant values by name (e.g. LogLevel.DEBUG) to represent different values in your application.
```


## Creating a UUID 

```java
import java.util.UUID;

// Generate a random UUID
UUID uuid = UUID.randomUUID();

// Create a UUID from a string representation
UUID uuidFromString = UUID.fromString("f4a92b7d-0f49-4d1c-b9a3-99e2d42a06eb");
```

To define a UUID (Universally Unique Identifier) in Java, you can use the java.util.UUID class. 

Once you have a UUID object, you can use it to uniquely identify objects or entities in your application. UUIDs are commonly used in distributed systems and databases to generate unique identifiers that can be used to identify objects across different machines or systems.


## Creating a Timestamp

```java
import java.time.LocalDateTime;
import java.time.Instant;

// Get the current timestamp as a LocalDateTime
LocalDateTime timestampLocal = LocalDateTime.now();

// Get the current timestamp as an Instant
Instant timestampInstant = Instant.now();
```

In Java, you can represent a timestamp using either the LocalDateTime or Instant class from the java.time package.


`LocalDateTime` represents a date and time without a time zone, while `Instant` represents a point in time on the timeline in Coordinated Universal Time (UTC).
  

## Step function
 

Java or Spring Boot, a step function typically refers to a specific task or action that needs to be performed as part of a larger process or workflow.

In the context of Spring Batch, a popular framework for building batch processing applications in Spring Boot, a step function is a unit of work that performs a specific task, such as reading data from a file, processing it, and writing the results to a database. Each step function is typically defined as a Java class that implements the Step interface, and it can be configured with various properties and options to control its behavior.

Here's an example of a simple step function in Spring Batch that reads data from a CSV file and writes it to a database:

```java
@Component
public class CsvToDatabaseStep implements Step {

    @Autowired
    private CsvReader csvReader;

    @Autowired
    private DatabaseWriter databaseWriter;

    @Override
    public void execute() {
        List<Person> people = csvReader.read("people.csv");
        databaseWriter.write(people);
    }

    // Other methods and properties of the Step interface...
}
```

In this example, the **CsvToDatabaseStep** class reads data from a CSV file using a CsvReader component and writes it to a database using a DatabaseWriter component. When the step function is executed as part of a larger batch process, it will perform this task and then move on to the next step in the workflow.
