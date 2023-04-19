public class Square extends GeometricObject{
	public double length;

	public Square(double length){
		this.length = length;
	}

	@Override
	public void draw(){
		System.out.println("Drawing Square");
	}

	@Override
	public double getPerimeter(){
		return 4*length;

	}

}