package geometries;
import primitives.Point3D;

public class Triangle extends Polygon {
     
	public Triangle (Point3D a, Point3D b, Point3D c)
	{
		super(a,b,c);
	}

	@Override
	public String toString() {
		return "Triangle [_vertices=" + vertices + ", _plane=" + plane + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
