package primitives;

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

    public Point3D getPoint() {
        return point;
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
