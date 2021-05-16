package renderer;

import geometries.Intersectable.*;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.List;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = _scene.geometries.findGeomIntersections(ray);
        if (intersections != null) {
            GeoPoint closestPoint = ray.getClosestGeoPoint(intersections);
            return calcColor(closestPoint);
        }
        //ray did not intersect any geometrical object
        return _scene.background;
    }

    private Color calcColor(GeoPoint point) {
        return _scene.ambientlight.getIntensity()
                .add(point.geometry.getEmission())
               ;
    }
}
