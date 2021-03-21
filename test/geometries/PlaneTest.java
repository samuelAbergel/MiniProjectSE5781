package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void getNormal() {
        Vector v = new Vector(new Point3D(2.0,2.0,2.0));
        Plane test = new Plane(new Point3D(1.0,1.0,1.0),new Vector(new Point3D(2.0,2.0,2.0)));
        assertEquals(v.getHead().getX(),test.getNormal().getHead().getX());
        assertEquals(v.getHead().getY(),test.getNormal().getHead().getY());
        assertEquals(v.getHead().getZ(),test.getNormal().getHead().getZ());

    }


    @Test
    void testGetNormal() {
        Vector v = new Vector(new Point3D(2.0,2.0,2.0));
        Plane test = new Plane(new Point3D(1.0,1.0,1.0),new Vector(new Point3D(2.0,2.0,2.0)));
        assertEquals(v.getHead().getX(),test.getNormal().getHead().getX());
        assertEquals(v.getHead().getY(),test.getNormal().getHead().getY());
        assertEquals(v.getHead().getZ(),test.getNormal().getHead().getZ());
    }

    @Test
    void findIntersections() {
        Plane test = new Plane(new Point3D(1.0,1.0,1.0),new Vector(new Point3D(2.0,2.0,2.0)));
        List<Point3D> result;
        result = test.findIntersections(new Ray(new Point3D(4.91,0.41,2.6),new Vector(new Point3D(-3,0,0))));
        assertEquals(result.get(0),new Point3D(-0.009999999999999787,0.41,2.6));
    }
}