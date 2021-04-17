package primitives;

import java.util.Objects;

import static primitives.Point3D.ZERO;

public class Vector {
    Point3D _head;

    public Vector(Point3D head) {
        if (head.equals(ZERO)) {
            throw new IllegalArgumentException("Vector head cannot be Point(0,0,0)");
        }
        _head = head;
    }



    public Point3D getHead() {
        return _head;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }

    public double dotProduct(Vector v) {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return (u1 * v1 + u2 * v2 + u3 * v3);
    }

    public Vector crossProduct(Vector v) {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return new Vector(new Point3D(
                u2*v3-u3*v2,
                u3*v1-u1*v3,
                u1*v2-u2*v1
        ));
    }
    public Vector add(Vector v)
    {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;
        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return new Vector(new Point3D(
                u1 + v1,
                u2 + v2,
                u3 + v3
        ));
    }

    public Vector subtract(Point3D v)
    {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;
        double v1 = v._x.coord;
        double v2 = v._y.coord;
        double v3 = v._z.coord;

        return new Vector(new Point3D(u1 - v1,u2 - v2,u3 - v3 ));
    }

    public Vector scale(double v)
    {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;


        return new Vector(new Point3D(
                u1 *v,
                u2 *v,
                u3 *v
        ));
    }
    public double lengthSquared() {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;


        return ((u1* u1)+(u2* u2)+(u3* u3));
    }

    public double length() {

     return Math.sqrt(lengthSquared());
    }

    public Vector normalize()
    {
        double m=length();
        this._head._x.coord/=m;
        this._head._y.coord/=m;
        this._head._z.coord/=m;

        return this;
    }

    public Vector normalized()
    {
        Vector result  = new Vector(_head);
        result.normalize();
        return result;
       /* Vector vec = new Vector(new Point3D( this._head._x.coord,this._head._y.coord,this._head._z.coord)).normalize();
        return vec;*/

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector other = (Vector) obj;
        if (_head == null) {
            if (other._head != null)
                return false;
        } else if (!_head.equals(other._head))
            return false;
        return true;
    }
    /**
     * @param axis axis of rotation
     * @param theta angle of rotation
     *
     */
    public void rotateVector(Vector axis, double theta) {
        double x = this._head._x.coord;
        double y = this._head._y.coord;
        double z = this._head._z.coord;

        double u = axis._head._x.coord;
        double v = axis._head._y.coord;
        double w = axis._head._z.coord;

        double v1 = u * x + v * y + w * z;

        double thetaRad = Math.toRadians(theta);

        double xPrime = u * v1 * (1d - Math.cos(thetaRad))
                + x * Math.cos(thetaRad)
                + (-w * y + v * z) * Math.sin(thetaRad);

        double yPrime = v * v1 * (1d - Math.cos(thetaRad))
                + y * Math.cos(thetaRad)
                + (w * x - u * z) * Math.sin(thetaRad);

        double zPrime = w * v1 * (1d - Math.cos(thetaRad))
                + z * Math.cos(thetaRad)
                + (-v * x + u * y) * Math.sin(thetaRad);

        this._head = new Point3D(xPrime, yPrime, zPrime);
    }
  }
