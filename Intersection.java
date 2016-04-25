package RayTracing;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Intersection {


	private List<SingleIntersection> allIntersections;
	
	public Intersection(List<Object3D> primitives,Ray ray){
		allIntersections=new ArrayList<SingleIntersection>();
		
		double curTmpDistance;
		for(Object3D obj:primitives){
			curTmpDistance=obj.getIntersection(ray);
			if(curTmpDistance>0 ){
				allIntersections.add(new SingleIntersection(
						ray.getOrigin().add(ray.getDirection().scale(curTmpDistance)), obj, curTmpDistance
				));		
			}
		}
		allIntersections.sort(new Comparator<SingleIntersection>(){
			@Override
			public int compare(SingleIntersection o1, SingleIntersection o2) {
				double distSub=o1.distance -o2.distance;
				return (distSub<0)	?	-1	:(	(distSub>0)	?1:0);
			}
			
			
		});
		
	}
	
	public SingleIntersection getFirstIntersection(){
		return getIntersectionAfter(0);
	}
	
	public SingleIntersection getIntersectionAfter(double minDistance) {
		for(SingleIntersection intersection: allIntersections){
			if(intersection.distance>minDistance){
				return intersection;
			}
		}
		return null;
	}


	
	
	public class SingleIntersection{
		private Tuple3D position;
		private Object3D object;
		private double distance;
		
		SingleIntersection(Tuple3D pos,Object3D obj, double dist){
			position=pos; object=obj; distance=dist;
		}
		
		public Tuple3D getPosition() {
			return position;
		}

		public Object3D getObject() {
			return object;
		}

		public double getDistance() {
			return distance;
		}
	}
}
