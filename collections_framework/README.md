# Java Collections

Explore the Java Collections Framework, which provides a variety of data structures like ArrayList, LinkedList, HashSet, HashMap, etc. This will help you to choose the right data structure for a specific task and improve the efficiency of your programs.

## ArrayList

An `ArrayList` is a resizable array that implements the `List` interface. It allows you to store elements in a specific order, and it automatically resizes itself as you add or remove elements. `ArrayList` provides fast access to elements by index but is slower when inserting or removing elements in the middle because it needs to shift elements.



```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
```  


Accessing an element 


```java

existingClass(){
	
        // Access an element by its index
        String secondName = names.get(1); // The index is 0-based, so 1 refers to the second element
        System.out.println("The second name in the list is: " + secondName);

        }
```



## LinkedList

A `LinkedList` is a doubly-linked list implementation of the `List` interface. It also stores elements in a specific order but uses a different internal data structure than `ArrayList`. Each element in a `LinkedList` is a node that contains a reference to the previous and next nodes in the list. `LinkedList` provides fast insertion and removal of elements at the beginning or end but slower access to elements by index compared to `ArrayList`.


```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        for (String name : names) {
            System.out.println(name);
        }
    }
}

```


- Use LinkedList when you need fast insertion or deletion of elements at the beginning or end of the list.
- Use LinkedList when you do not need frequent access to elements by index.
- Use LinkedList when you need to access the list concurrently from multiple threads.
- Do not use LinkedList when performance is a critical concern, and you need to frequently access elements by index.



## HashSet 

A `HashSet` is an implementation of the `Set` interface. It stores unique elements in no particular order. Internally, it uses a `HashMap` to store elements as keys. If you need to ensure that you have no duplicate elements in a collection and don't care about the order, a `HashSet` is an excellent choice.

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

Not **thread safe**

## hashMap

A `HashMap` is an implementation of the `Map` interface. It stores key-value pairs, where each key can map to at most one value. The keys in a `HashMap` are unique, and it uses a hash table for storage, which provides fast insertion, removal, and retrieval of elements. If you need to store data in key-value pairs and quickly access values by their keys, a `HashMap` is a great option.



```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);

        // Accessing a value by key
        int aliceAge = ages.get("Alice");
        System.out.println("Alice's age is " + aliceAge);

        for (String name : ages.keySet()) {
            System.out.println(name + " is " + ages.get(name) + " years old");
        }
    }
}

```

Not **thread safe**

## Map (not to be confused with the map datastruct/interface)

In this example, we first create a List of strings called fruits using the Arrays.asList method. We then use the stream method to convert the list to a stream, which allows us to use the map function.

The map function takes a lambda expression that defines how each element in the stream should be transformed. In this case, we use the String::toUpperCase method reference to convert each string to uppercase.

Finally, we use the collect method to convert the stream back to a list and store the result in upperCaseFruits. We then print out the list to verify that the strings have been converted to uppercase.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "kiwi");

        List<String> upperCaseFruits = fruits.stream()
                                             .map(String::toUpperCase)
                                             .collect(Collectors.toList());

        System.out.println(upperCaseFruits);
    }
}

```

The map function is a transformation operation that applies a given function (in this case, String::toUpperCase) to each element of the stream (the fruits list). It then returns a new stream with the transformed elements. The new stream is then collected into a list with collect(Collectors.toList()).

In this example, the map function is not related to the Map interface or data structure. Instead, it is a common functional programming concept that applies a function to each element of a collection (in this case, a stream). The naming can be confusing, but they represent different concepts in this context.

## Challenge 

Create a program that counts the occurrences of words in a list of strings using a HashMap. Your program should do the following:

- Create an ArrayList of strings.
- Add some words to the list. Some words should be added more than once to demonstrate counting.
- Create a HashMap to store the words as keys and their occurrences as values.
- Iterate through the ArrayList and use the HashMap to count the occurrences of each word.
- Iterate through the HashMap and print out each word and its occurrence count.
