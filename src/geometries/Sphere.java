package geometries;
import primitives.*;

import java.util.List;

public class Sphere extends RadialGeometry {
	Point3D center;
	
	public Sphere (Point3D p, double d)
	{
		super (d);
		this.center= p;
	}
	
	public Sphere (Point3D p, RadialGeometry other)
	{
		super (other);
		this.center= p;
	}
	
	public Point3D getCenter ()
	{
		return center;
	}
	 
	public Vector getNormal(Point3D c)
	{
		return  center.subtract(c).normalized();

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sphere [center=" + center + ", _radius=" + _radius + ", getCenter()=" + getCenter() + ", getRadius()="
				+ getRadius() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	@Override
	public List<Point3D> findIntersections(Ray ray) {
		Vector u = center.subtract(ray.getPoint());
		Vector v = ray.getVec();
		double tm = u.dotProduct(v);
		double d = Math.sqrt(u.lengthSquared() - tm*tm);

		if(d>_radius){
			return null;
		}
		double th = Math.sqrt(_radius*_radius - d*d );
		double t1 = tm -th;
		double t2 = tm+th;
		if(t1 > 0 && t2> 0){
			return List.of(ray.getPoint().add(v.scale(t1)),ray.getPoint().add(v.scale(t2)));
		}
		else if (t1 > 0){
			return List.of(ray.getPoint().add(v.scale(t1)));
		}
		else if (t2 > 0){
			return List.of(ray.getPoint().add(v.scale(t2)));
		}

		return null;
	}
}
