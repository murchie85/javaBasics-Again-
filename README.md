# JAVA NOTES

![](image.png)

## RELATED LINKS 
  
- [springboot_logapp](https://github.com/murchie85/springboot_logapp)


# CONTENTS

- [General Notes](General-Notes)
- [Specifics](Specifics)
- [Learning Curriculum](Learning-Curriculum)


## General Notes

- **TO RUN** the code, you need to first 
    - `javac myProg.java` then
    - `java nameOfMyEntryClassWithMainInIt` and ignore the .java  
- Two classes in same file means only one can have **public**
- If you have multiple files imported, you need to compile them all at the same time
    `javac BankAccount.java SavingsAccount.java CheckingAccount.java`
- If you have all java files at same level you don't need import statements



## Specifics

## Constructor

Must have the same name as the class
Don't give it a type, its just 


```java
public Car(String make, String model, int year){

	}
```


## Methods

Define the **return type**

```java
// Methods
public double getArea() {
    return Math.PI * radius * radius;
}
```


Set methods that don't return anything must have `void` as the type 

```java
    public void setRadius(double radius) {
        this.radius = radius;
    }
```


## Super 

- If extending you need to construct parent variables even if you don't use them
```java

package com.example.bank;

public class CheckingAccount extends BankAccount{
    public double overdraftLimit;

    // you HAVE TO construct all parent variables even if you don't use them 
    public CheckingAccount(double balance, String accountNumber, double overdraftLimit){
        super(balance, accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount){
        double balance = getBalance();
        if(balance-amount >= overdraftLimit){
            super.withdraw(amount);
        } else{
            System.out.println("withdrawal Denied: Exceeds overdraftLimit.");
        }
    }
}
```


## Learning Curriculum

 Each part can be found within the folder at the base of this project with the similar name. For example the classes have a list of projects, cylinder, square, circle etc all have examples of this.  


### Classes, Constructors, methods and objects 

Learn how to create classes, with variables, construct self variables, create methods and instantiate them inside a main class then log the output. 

### Inheritance and Polymorphism

Learn how to create and use subclasses and understand the concepts of inheritance, overriding, and polymorphism. This will help you design more efficient and reusable code.

### Interfaces and Abstract Classes

Understand the purpose of interfaces and abstract classes, and learn how to create and use them in your code. This will allow you to design more flexible and modular programs.

### Collections Framework

Explore the Java Collections Framework, which provides a variety of data structures like ArrayList, LinkedList, HashSet, HashMap, etc. This will help you to choose the right data structure for a specific task and improve the efficiency of your programs.

### Exception Handling

Learn how to handle exceptions in Java using try-catch-finally blocks and how to create custom exceptions. Proper exception handling can make your programs more robust and fault-tolerant.

### Java I/O

Learn about Java I/O classes and methods for reading and writing data from/to various sources like files, network sockets, etc.

### Concurrency

Understand Java threads and concurrency concepts, including synchronization and thread communication. This will help you create more efficient and responsive applications, especially when dealing with multi-threading.

### Java Networking

Learn about Java networking concepts and how to create client-server applications using Java sockets.

### Java GUI Programming

Explore Java GUI programming using JavaFX or Swing libraries. This will allow you to create user-friendly graphical interfaces for your applications.

### Java Database Connectivity (JDBC)

Learn how to interact with databases using Java JDBC. This will enable you to create data-driven applications.
