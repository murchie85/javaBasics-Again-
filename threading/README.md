# Threading 



**Thread-safety:**

- Describes a program or data structure that can be used safely by multiple threads.
- Prevents race conditions and other concurrency-related problems.
- Uses synchronization mechanisms to ensure that only one thread can access a critical section of code or data structure at a time.

**Thread-safe property:**

- Can be accessed by both threads, but only in a *safe and consistent* manner.
- Must be accessed using proper synchronization mechanisms such as locks, mutexes, or atomic operations.
- Example: use synchronized methods to ensure that only one thread can access a critical section of code or data structure at a time.


```java 
public class MyClass {
    private int myProperty;

    public synchronized void setMyProperty(int value) {
        myProperty = value;
    }

    public synchronized int getMyProperty() {
        return myProperty;
    }
}
```