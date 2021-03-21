package geometries;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TubeTest {

    @Test
    void getNormal() {
        Point3D center =  new Point3D(0,1,0);
        Tube test = new Tube(new Ray(new Point3D(1,0,0),new Vector(new Point3D(1,0,0))),1.0);
        Vector test1 = test.getNormal(new Point3D(0,1,0));
        assertEquals(new Coordinate(0.0),test1.getHead().getX());
        assertEquals(new Coordinate(1.0),test1.getHead().getY());
        assertEquals(new Coordinate(0.0),test1.getHead().getZ());
    }

    @Test
    void findIntersections() {
        List<Point3D> result;
        Tube test = new Tube(new Ray(new Point3D(1,1,1),new Vector(new Point3D(1,2,1))),2);
        result = test.findIntersections(new Ray(new Point3D(4.91,0.41,2.6),new Vector(new Point3D(-3,0,0))));
        //assertEquals(result.get(0),);
        test = new Tube(new Ray(new Point3D(1,1,1),new Vector(new Point3D(1,2,1))),1);
        result = test.findIntersections(new Ray(new Point3D(3,0,0),new Vector(new Point3D(-3,0,1))));
        assertEquals(result.get(0),new Point3D(1.5891172356779835,0,0.47029425477400555));
        assertEquals(result.get(1),new Point3D(-0.3034029499636972,0,1.1011343166545657));
    }
}