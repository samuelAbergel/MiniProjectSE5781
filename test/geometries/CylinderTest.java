package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void getNormal() {
        Cylinder test = new Cylinder(new Ray(new Point3D(0,0,0),new Vector(new Point3D(1,1,0))),2.0,2.0);
        Vector Normaltest = test.getNormal(new Point3D(1.0,1.0,1.0));
        Vector Expected = new Point3D(0,0,1.0).subtract(new Point3D(0,0,0)).normalized();
        assertEquals(Expected.getHead().getX(),Normaltest.getHead().getX());
        assertEquals(Expected.getHead().getY(),Normaltest.getHead().getY());
        assertEquals(Expected.getHead().getZ(),Normaltest.getHead().getZ());
    }
}