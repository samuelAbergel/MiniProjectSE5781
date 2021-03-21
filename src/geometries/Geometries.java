package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    List<Intersectable> intersectables = null;

    public Geometries() {
        this.intersectables = new LinkedList<>();
    }

    public Geometries(Intersectable... intersectables) {
        this.intersectables = new LinkedList<>();
        add(intersectables);
    }

    private void add(Intersectable[] intersectables) {
        for(Intersectable item : intersectables)
        {
            this.intersectables.add(item);
        }
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        for(Intersectable item : this.intersectables){
            List<Point3D>itemPoints = item.findIntersections(ray);
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