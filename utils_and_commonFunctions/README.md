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