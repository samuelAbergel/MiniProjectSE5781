package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {
        Point3D centerTest = new Point3D(1, 0, 1);
        Sphere Stest = new Sphere(new Point3D(2, 0, 2), 1.0);
        Vector result = Stest.getNormal(centerTest);
        Vector test = new Vector(new Point3D(1, 0, 1)).normalized();
        assertEquals(result.getHead().getX(), test.getHead().getX());
        assertEquals(result.getHead().getY(), test.getHead().getY());
        assertEquals(result.getHead().getZ(), test.getHead().getZ());
    }

    @Test
    void findIntersections() {
        Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1d);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(new Point3D(1, 1, 0)))), "Ray's line out of sphere");


        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0),
                new Vector(new Point3D(3, 1, 0))));
        assertEquals(2, result.size(), "Wrong number of points");
         //if (result.get(0).getX(). > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(p2, p1), result, "Ray crosses sphere");

    }
}