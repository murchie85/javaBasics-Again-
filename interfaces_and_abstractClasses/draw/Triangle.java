public class Triangle extends GeometricObject{
	public double sideA;
	public double sideB;
	public double sideC;


	public Triangle(double sideA, double sideB, double sideC){
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	@Override
	public void draw(){
		System.out.println("Drawing a Triangle");
	}

	@Override
	public double getPerimeter(){
		return sideA + sideB + sideC;
	}
}