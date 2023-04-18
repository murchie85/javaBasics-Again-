# JAVA NOTES

![](image.png)

## RELATED LINKS 
  
- [springboot_logapp](https://github.com/murchie85/springboot_logapp)


## General Notes  

- **TO RUN** the code, you need to first 
    - `javac myProg.java` then
    - `java nameOfMyEntryClassWithMainInIt` and ignore the .java  
- Two classes in same file means only one can have **public**




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
