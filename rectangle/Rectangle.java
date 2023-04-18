public class Rectangle{
	// vars
	double length;
	double width;

	// constructor 
	public Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}

	// method
	public double getArea(){
		return length * width;
	}

	// method
	public double getPerimeter(){
		return 2* (length+width);
	}


	public double getWidth(){
		return width;
	}

	public double getLength(){
		return length;
	}

	void setWidth(double width){
		this.width = width;
	}

	void setLength(double length){
		this.length  = length;
	}
}


class RectangleTest{
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(10,10);
		Rectangle rectangle2 = new Rectangle(20,15);

		System.out.println("Rectangle 1 Area is : " + rectangle1.getArea());
		System.out.println("Rectangle 1 Perimiter is : " + rectangle1.getPerimeter());

		System.out.println("Rectangle 2 Area is " + rectangle2.getArea());
		System.out.println("Rectangle 2 Perimiter is : " + rectangle2.getPerimeter()); 
	}
}


