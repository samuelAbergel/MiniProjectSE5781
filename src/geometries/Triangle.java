package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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

	public Vector getNormal(Point3D c)
	{
		return super.getNormal(c).normalized();
	}

	public List<Point3D> findIntersection(Ray ray)
	{
		List<Point3D> List = plane.findIntersections(ray);
		if(List == null)
		{
			return null;
		}
		Point3D test = List.get(0);
		Vector v1 = ray.getPoint().subtract(vertices.get(0));
		Vector v2 = ray.getPoint().subtract(vertices.get(1));
		Vector v3 = ray.getPoint().subtract(vertices.get(2));
		Vector n1 = (vertices.get(1).subtract(vertices.get(0))).crossProduct(v1).normalize();
		Vector n2 = (vertices.get(2).subtract(vertices.get(1))).crossProduct(v2).normalize();
		Vector n3 = (vertices.get(0).subtract(vertices.get(2))).crossProduct(v3).normalize();
		double number1 = ray.getVec().dotProduct(n1);
		double number2 = ray.getVec().dotProduct(n2);
		double number3 = ray.getVec().dotProduct(n3);
		if(number1 >= 0 && number2 >= 0 && number3 >= 0)
		{
			return List;
		}
		if(number1 <= 0 && number2 <= 0 && number3 <= 0) {
			return List;
		}
		return null;
	}
}
