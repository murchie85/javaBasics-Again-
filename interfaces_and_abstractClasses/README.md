# Interfaces and Abstract Classes

## Notes  

- **Abstract classes** can not be instantiated, only extended.
- When `@Override` the parent class method you don't need to say abstract  




## Key summary

1. You first define an interface
2. then create an abstract class that implements that interface, 
3. finally, create concrete classes extending the abstract class.



- Interfaces mean **classes MUST provde** their own override of those methods
- An interface is an abstract class with **NO concrete methods**
- Concrete methods **can be ignored by subclasses**

When extending an abstract class:

You inherit all non-private members, including concrete and abstract methods.
You can choose to use or ignore the concrete methods from the abstract class.
You must provide an implementation for all abstract methods, unless your subclass is also abstract.

  

Another key difference is that a class can implement multiple interfaces but can only extend one (abstract) class. This enables a form of multiple inheritance in Java through interfaces.


## Interfaces  

An interface is a collection of abstract methods that can be implemented by any class. A class can implement multiple interfaces, which allows for a form of multiple inheritance. Interfaces are defined using the `interface` keyword.

Here's an example of an `interface` and a class implementing the `interface`:  


```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("The bird is flying!");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("The airplane is flying!");
    }
}
```  

Interfaces in Java are **implicitly abstract**; they can contain only abstract methods, which means the methods **do not have a body** (implementation). So, in the Flyable interface, the fly() method is abstract.


When a class "implements" an interface, it means that the class is committing to providing implementations for all the abstract methods defined in that interface. A class can implement multiple interfaces, and in doing so, it can inherit the methods from each of those interfaces. Implementing an interface is a way of establishing a contract between the class and the interface. This contract ensures that the class provides specific behavior as defined by the methods in the interface.

When a class "extends" another class, it means that the new class is a subclass of the parent class (also called the superclass). The subclass **inherits all non-private fields** and methods from the superclass, **including non-abstract methods** with their implementations. A **subclass can override inherited methods** to provide its own implementation or can use the inherited methods as they are. In Java, a class can extend only one other class, which is called single inheritance.

To summarize, "implementing" is used when a class wants to conform to the behavior defined by an interface, and "extending" is used when a class wants to inherit properties and behaviors from a superclass. Implementing is for interfaces, while extending is for classes.

## Abstract Classes  

An abstract class is a class that **cannot be instantiated** and is meant to be **subclassed** by other classes. Abstract classes can have both abstract and non-abstract methods.

Here's an example of an abstract class and its subclasses:  

```java
abstract class Shape {
    abstract double getArea();

    void printArea() {
        System.out.println("The area is: " + getArea());
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}
```








# Challenge

Create an interface called `Drawable` with a method called `draw()`. Next, create an abstract class called `GeometricObject` that implements the `Drawable` interface. `GeometricObject` should have a method called `getPerimeter()`.

Now, create two subclasses of `GeometricObject`: `Triangle` and `Square`. Each subclass should have its own implementation of the `draw()` and `getPerimeter()` methods. In the `draw()` method, print out a description of the object, such as "Drawing a triangle" or "Drawing a square". In the `getPerimeter()` method, calculate and return the perimeter of the shape.

Finally, create a `TestDrawing` class with a `main` method. In the `main` method, create an array of `Drawable` objects containing instances of `Triangle` and `Square`. Use a loop to call the `draw()` method for each object in the array.
