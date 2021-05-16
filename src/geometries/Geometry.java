package geometries;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public abstract class Geometry implements  Intersectable{
     protected Color _emission = Color.BLACK;
    public abstract Vector getNormal(Point3D p);

    public Color getEmission() {
        return _emission;
    }

    /**
     *
     * @param emission
     * @return
     */
    public Geometry setEmission(Color emission) {
        _emission = emission;
        return this;
    }
}