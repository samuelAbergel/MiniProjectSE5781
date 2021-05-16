package primitives;

import geometries.Intersectable.*;

import java.util.List;

public class Ray {
    Point3D point;
    Vector vec;

    public Ray (Point3D p, Vector v)
    {
        this.vec=v;
        if (this.vec.normalize() == this.vec)
        {
            this.point=p;
        }
        else
        {
            this.vec.normalize();
            this.point=p;
        }
    }
    public GeoPoint getClosestGeoPoint(List<GeoPoint> pointsList){
        GeoPoint result =null;
        double closestDistance = Double.MAX_VALUE;

        if(pointsList== null){
            return null;
        }

        for (GeoPoint geo: pointsList) {
            double temp = geo.point.distance(point);
            if(temp < closestDistance){
                closestDistance =temp;
                result =geo;
            }
        }

        return  result;
    }

    public void setPoint(Point3D point) {
        this.point = point;
    }

    public Vector getVec() {
        return vec;
    }

    public void setVec(Vector vec) {
        this.vec = vec;
    }

    @Override
    public String toString() {
        return "Ray [point=" + point + ", vec=" + vec + ", getPoint()=" + getPoint() + ", getVec()=" + getVec()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

    private Point3D getPoint() {
        return point;
    }

    /**
     * find the closest Point to Ray origin
     * @param pointsList intersections point List
     * @return closest point
     */
    public Point3D findClosestPoint(List<Point3D> pointsList){
        Point3D result =null;
        double closestDistance = Double.MAX_VALUE;

        if(pointsList== null){
            return null;
        }

        for (Point3D p: pointsList) {
            double temp = p.distance(point);
            if(temp < closestDistance){
                closestDistance =temp;
                result =p;
            }
        }

        return  result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ray other = (Ray) obj;
        if (point == null) {
            if (other.point != null)
                return false;
        } else if (!point.equals(other.point))
            return false;
        if (vec == null) {
            if (other.vec != null)
                return false;
        } else if (!vec.equals(other.vec))
            return false;
        return true;
    }


    public Point3D getTargetpoint(double t) {
        return point.add(vec.scale(t));
    }
}
