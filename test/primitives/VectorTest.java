package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class VectorTest {

    final Vector v1 = new Vector(new Point3D(1, 2, 3));
    final Vector v2 = new Vector(new Point3D(-2, -4, -6));

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    void dotProduct() {
        try {
            assertEquals(-28.0, v1.dotProduct(v2), 0);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {


        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(new Point3D(0, 3, -2));
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals(v1.length() * v3.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v3)), "crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {
        }
    }

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    void add() {
        try {
            assertEquals(-1.0, v1.add(v2).getHead().getX().coord, 0);
            assertEquals(-2.0, v1.add(v2).getHead().getY().coord, 0);
            assertEquals(-3.0, v1.add(v2).getHead().getZ().coord, 0);

        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }
    /**
     * Test method for #subtract.
     */
    @Test
    void subtract() {
        try {
            assertEquals(3.0, v1.subtract(v2.getHead()).getHead().getX().coord, 0);
            assertEquals(6.0, v1.subtract(v2.getHead()).getHead().getY().coord, 0);
            assertEquals(9.0, v1.subtract(v2.getHead()).getHead().getZ().coord, 0);

        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }
    /**
     * Test method for #scale.
     */
    @Test
    void scale() {
        Vector test2 = null;
        // ============ Equivalence Partitions Tests ==============
        Vector test = new Vector(new Point3D(1.0, 1.0, 1.0));
        test2 = test.scale(2);
        try {
            assertEquals(2.0, test2.getHead().getX().coord, 0);
            assertEquals(2.0, test2.getHead().getY().coord, 0);
            assertEquals(2.0, test2.getHead().getZ().coord, 0);
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }
    /**
     * Test method for #lengthSquared.
     */
    @Test
    void lengthSquared() {
        double test = v1.lengthSquared();
        assertEquals(14.0,test,0);
        test = v2.lengthSquared();
        assertEquals(56.0,test,0);
    }
    /**
     * Test method for #length.
     */
    @Test
    void length() {
        double test = v1.length();
        assertEquals(Math.sqrt(14.0),test,0);
        test = v2.length();
        assertEquals(Math.sqrt(56.0),test,0);
    }
    /**
     * Test method for #normalize.
     */
    @Test
    void normalize() {
        Vector v = new Vector(new Point3D(3.5, -5, 10));
        v.normalize();
        assertEquals(1, v.length(), 1e-10);
        try {
            v = new Vector(new Point3D(0, 0, 0));
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            v.normalize();
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }
    /**
     * Test method for #normalized.
     */
    @Test
    void normalized() {
        Vector V1 = new Vector(new Point3D(1.0,1.0,1.0));
        double test = V1.normalized().length();
        assertEquals(1,test,0);
        V1 = new Vector(new Point3D(-2.0,4.0,-3.0));
        test = V1.normalized().length();
        assertEquals(1.0,test,0);
    }
}