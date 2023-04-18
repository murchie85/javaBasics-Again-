public class Circle {
    // Field
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Methods
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(20);

        System.out.println("Circle 1 radius: " + circle1.getRadius());
        System.out.println("Circle 1 area: " + circle1.getArea());
        System.out.println("Circle 1 circumference: " + circle1.getCircumference());

        System.out.println("Circle 2 radius: " + circle2.getRadius());
        System.out.println("Circle 2 area: " + circle2.getArea());
        System.out.println("Circle 2 circumference: " + circle2.getCircumference());
    }
}
