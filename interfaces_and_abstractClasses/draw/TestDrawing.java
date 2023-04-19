public class TestDrawing{
	public static void main(String[] args){
		Triangle t1 = new Triangle(10,20,30);
		Square   s1 = new Square(20);


		GeometricObject[] shapes = new GeometricObject[2];
		shapes[0] = t1;
		shapes[1] = s1;

		for (GeometricObject shape: shapes){
			shape.draw();
			double perimeter = shape.getPerimeter();
			System.out.println("Perimeter is " + perimeter);
		}
	}
}