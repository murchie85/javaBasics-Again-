public class Triangle{
	
	// vars 
	private double sideA;
	private double sideB;
	private double sideC;

	// constructor 

	public Triangle(double sideA, double sideB, double sideC){
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;

	}


	// method 

	public double getArea(){
		double s = (sideA + sideB + sideC)/2;
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}

	// method 

	public double getPerimeter(){
		return sideA + sideB + sideC;
	}

	// gettrs 

	public double getSideA(){
		return sideA;
	}
	public double getSideB(){
		return sideB;
	}
	public double getSideC(){
		return sideC;
	}

	// settrs 

	public void setSideA(double sideA){
		this.sideA = sideA;
	}
	public void setSideB(double sideB){
		this.sideB = sideB;
	}
	public void setSideC(double sideC){
		this.sideC = sideC;
	}


}


class testTriangle{
	public static void main(String[] args){

		Triangle triangle1 = new Triangle(10,10,10);
		Triangle triangle2 = new Triangle(20,20,20);


		System.out.println("Triangle 1 area is : " + triangle1.getArea());
		System.out.println("Triangle 1 perimiter is : " + triangle1.getPerimeter());


		System.out.println("Triangle 2 area is : " + triangle2.getArea());
		System.out.println("Triangle 2 perimiter is : " + triangle2.getPerimeter());


	}
}


