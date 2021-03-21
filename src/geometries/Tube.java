package geometries;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Tube extends RadialGeometry {	
	Ray _axisRay;
	
	public Tube (Ray r, double d)
	{
		super (d);
		this._axisRay=r;		
	}
	
	public Tube (Ray r, RadialGeometry g)
	{
		super (g);
		this._axisRay=r;		
	}
	
	public Ray getRay()
	{
		return _axisRay;
	}

	@Override
	public Vector getNormal(Point3D temp)
	{
		double t = _axisRay.getVec().dotProduct(temp.subtract(_axisRay.getPoint()));
		Point3D o = _axisRay.getPoint().add(_axisRay.getVec().scale(t));
		return temp.subtract(o).normalized();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tube other = (Tube) obj;
		if (_axisRay == null) {
			if (other._axisRay != null)
				return false;
		} else if (!_axisRay.equals(other._axisRay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tube [_axisRay=" + _axisRay + ", _radius=" + _radius + ", getRay()=" + getRay() + ", getRadius()="
				+ getRadius() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	@Override
	public List<Point3D> findIntersections(Ray ray) {
		List<Point3D> resultPoint = new ArrayList<Point3D>();
		Vector vVAVA;
		Vector minus,deltaP;
		double VVA = ray.getVec().dotProduct(_axisRay.getVec());
		if(VVA == 0)
		{

		}
		vVAVA =_axisRay.getVec().scale(VVA);
		try {
			minus = ray.getVec().subtract(vVAVA.getHead());
		}
		catch (Exception e)
		{
			return null;
		}
		try
		{
			deltaP = ray.getPoint().subtract(_axisRay.getPoint());
		}
		catch (Exception e)
		{
			if(VVA == 0)
			{
				resultPoint.add(ray.getTargetpoint(_radius));
				return resultPoint;
			}
			resultPoint.add(ray.getTargetpoint(_radius*_radius / minus.lengthSquared()));
			return resultPoint;
		}
		double a = minus.lengthSquared();
		double PVAaxys = deltaP.dotProduct(_axisRay.getVec());
		Vector dpminus = null,dpVAVA;
		if(PVAaxys == 0)
		{
			dpminus = deltaP;
		}
		else {
			dpVAVA = _axisRay.getVec().scale(PVAaxys);
			try
			{
				dpminus = deltaP.subtract(dpVAVA.getHead());
			}
			catch (Exception e)
			{
				resultPoint.add(ray.getTargetpoint(Math.sqrt(_radius*_radius/a)));
			}
		}
		double b = 2 * minus.dotProduct( dpminus );
		double c = dpminus.lengthSquared()- _radius*_radius;
		List<Double> result = MathHelp.SecondDegree(a,b,c);
		resultPoint.add(ray.getTargetpoint(result.get(0)));
		resultPoint.add(ray.getTargetpoint(result.get(1)));
		return resultPoint;
	}
}
