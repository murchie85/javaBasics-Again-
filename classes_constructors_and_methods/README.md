# Classes, Constructors and Methods 


In this module, you learned about:

- **Classes**: You learned how to create classes, which are blueprints for creating objects. Classes define the structure and behavior of objects through their fields and methods.
- **Constructors**: You learned about constructors, which are special methods that initialize objects when they are created. Constructors are called when you create a new instance of a class using the `new` keyword.
- **Methods**: You learned about methods, which are functions defined within a class that perform specific tasks. Methods can be used to define the behavior of objects or to manipulate their fields.
- **Access Modifiers**: You learned about access modifiers, such as `public`, `private`, and `protected`, which control the visibility of classes, fields, and methods. You used them to encapsulate your code and follow the principles of object-oriented programming.
- **Getters and Setters**: You learned about getter and setter methods, which are used to access and modify the private fields of a class. They follow the principle of encapsulation by ensuring that the internal state of an object is only modified through controlled methods.


```java

public class Cylinder{
	private double radius;
	private double height;

	public Cylinder(double radius, double height){
		this.radius = radius;
		this.height = height;
	}

	public double getVolume(){
		return Math.PI * radius*radius*height;
	}

	public double getSurfaceArea(){
		return 2 * Math.PI * radius * (radius + height);
	}

	public double getHeight(){
		return height;
	}

	public double getRadius(){
		return radius;
	}

	public void setRadius(double radius){
		this.radius = radius;
	}

	public void setHeight(double height){
		this.height = height;
	}
}



class testCylinder{
	public static void main(String[] args){
		Cylinder cylinder1 = new Cylinder(20,100);
		Cylinder cylinder2 = new Cylinder(50,200);


		System.out.println("The volume of cylinder 1 is : " + cylinder1.getVolume());
		System.out.println("The surface area of cylinder 1 is : " + cylinder1.getSurfaceArea());

		System.out.println("The volume of cylinder 2 is : " + cylinder2.getVolume());
		System.out.println("The surface area of cylinder 2 is : " + cylinder2.getSurfaceArea());

	}
}

```