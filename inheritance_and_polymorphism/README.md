# Inheritance and polymorphism

**Inheritance** 

use the `@Override` convention.  

is a mechanism in which one **class acquires** the **properties** (fields) and behaviors (methods) of another class.   

The class that is inherited is called the "parent" or "superclass," and the class that inherits from the parent is called the "child" or "subclass." Inheritance is useful for reusing code and creating a more organized and modular codebase. 

**important** `extends` means just that, it extends usually a `skeleton class` like shape below

```java

public class Shape {
    public double getArea() {
        return 0;
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

```



**Polymorphism**   


allows objects of different classes to be treated as objects of a common superclass.    

 It enables you to write code that can work with different types of objects without knowing their specific classes at compile-time. Polymorphism is particularly useful when working with **class hierarchies** and **interfaces**.

**BASICALLY** it just means using common methods of all the extended classes (from shape.)


 ```java
 public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Circle(3);

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());
        }
    }
}

```  

Obviously the for loop would fail if it used a shape specific method i.e. `getRadius`  

```java
for (Shape shape : shapes) {
    if (shape instanceof Circle) {
        Circle circle = (Circle) shape;
        System.out.println("Circle radius: " + circle.getRadius());
    } else if (shape instanceof Rectangle) {
        Rectangle rectangle = (Rectangle) shape;
        System.out.println("Rectangle width: " + rectangle.getWidth() + ", height: " + rectangle.getHeight());
    }
}

```

Above solves it but not ideal, better is just to have a method Override that does a different thing for each.  





