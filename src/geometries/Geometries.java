package geometries;

import primitives.Ray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public  class Geometries implements Intersectable {
    List<Intersectable> intersectables = null;

    public Geometries() {
        this.intersectables = new LinkedList<>();
    }

    public Geometries(Intersectable... intersectables) {
        this.intersectables = new LinkedList<>();
        add(intersectables);
    }

    public void add(Intersectable... geos) {
        Collections.addAll(intersectables, geos);
    }



    @Override
    public List<GeoPoint> findGeomIntersections(Ray ray) {
        List<GeoPoint> result = null;
        for(Intersectable item : this.intersectables){
            List<GeoPoint>itemPoints = item.findGeomIntersections(ray);
            if(itemPoints!= null){
                if(result == null){
                    result = new LinkedList<>();
                }
                result.addAll(itemPoints);
            }
        }
        return result;
    }
}
