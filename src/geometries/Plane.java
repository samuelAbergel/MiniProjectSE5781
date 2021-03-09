package geometries;

import primitives.*;

public class Plane implements Geometry {

	Point3D _p;
	Vector _normal;

	public Plane(Point3D _p, Vector vec1) {
		super();
		this._p = _p;
		this._normal = vec1;
	}

	public Plane(Point3D p1, Point3D p2, Point3D p3) {

		  Vector U = p2.subtract(p1);
		  Vector V = p3.subtract(p1);

		  Vector N = U.crossProduct(V);
		  N.normalize();
        _normal = N;
		this._p=p1;
	}

	public Vector getNormal() {
		return _normal;
	}
	
	 public Vector getNormal(Point3D p) {
	        return _normal;
	    }

	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + ", getClass()=" + getClass() + 
				 ", toString()=" + super.toString() + "]";
	}

	
	
	
}
