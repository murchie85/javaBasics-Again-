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