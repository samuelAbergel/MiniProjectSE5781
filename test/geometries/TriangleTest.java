package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getNormal() {
        new PolygonTest().testGetNormal();
    }

    @Test
    void findIntersection() {
        Triangle test = new Triangle(new Point3D(0,0,0),new Point3D(-2,0,0),new Point3D(0,0,2));
        Point3D testPoint = new Point3D(0,-2,0);
        List<Point3D> result;
        //----EP test
        //test1 D is in the triangle
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(-0.83,2,0.58))));
        assertEquals(result.get(0),new Point3D(-0.83,0,0.58));
        //test1 D is outside
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(-2,2,2))));
        assertNull(result);
        //test3 D is in a ray of the triangle
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(0.5,2,0))));
        assertNull(result);

        //------BVA CASE the ray isn't in the plane
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(-1.61,-0.13,0))));
        assertNull(result);
        //------BVA CASE the ray touch one ray of the triangle
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(-1,2,0))));
        assertEquals(result.get(0),new Point3D(-1,0,0));
        //------BVA CASE the ray touch one point of the triangle
        result = test.findIntersection(new Ray(testPoint,new Vector(new Point3D(-2,2,0))));
        assertEquals(result.get(0),new Point3D(-2,0,0));
    }
}