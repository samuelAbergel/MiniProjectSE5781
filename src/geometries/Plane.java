package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

public class Plane extends Geometry {

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
        this._p = p1;
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


    @Override
    public List<GeoPoint> findGeomIntersections(Ray ray) {
        Point3D P0 = ray.getPoint();
        Vector v = ray.getVec();
        if (_p.equals(P0)) {
            return List.of(new GeoPoint(this,_p));
        }
//the ray lying on the plane
        double nv = _normal.dotProduct(v);
        if (isZero(nv)) {
            return null;
        }
        double t = _normal.dotProduct(_p.subtract(P0));
        t /= nv;
        return List.of(new GeoPoint(this, ray.getTargetpoint(t)));
    }
}
