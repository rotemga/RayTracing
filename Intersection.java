package RayTracing;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Intersection {

	private List<SingleIntersection> allIntersections;
	private Ray Ray;
	/*
	public Intersection(Object3D obj,Ray ray){
		allIntersections=new ArrayList<SingleIntersection>();
		double distance=obj.getIntersection(ray);
		if(distance>0 ){
			Tuple3D location=ray.getLocationAtTime(distance);
			allIntersections.add(new SingleIntersection(location, obj, distance));		
		}
	}*/
	
	public Intersection(List<Object3D> primitives,Ray ray){
		Ray= ray;
		allIntersections=new ArrayList<SingleIntersection>();
		
		double curTmpDistance;
		for(Object3D obj:primitives){
			curTmpDistance=obj.getIntersection(ray);
			if(curTmpDistance>0 ){
				Tuple3D location=ray.getLocationAtTime(curTmpDistance);
				allIntersections.add(new SingleIntersection(
						location, obj, curTmpDistance,ray.getDirection().scale(-1)
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
	
	public Ray getRay() {
		return Ray;
	}



	public SingleIntersection getFirstIntersection(){
		return getIntersectionAfter(0);
	}
	
	public SingleIntersection getIntersectionByIndex(int index){
		if(allIntersections.size()>index && index>=0){
			return  allIntersections.get(index);	
		}
		return null;
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
		private Tuple3D hitNormal;		
		private Object3D object;
		private double distance;
		
		
		SingleIntersection(Tuple3D pos,Object3D obj, double dist,Tuple3D hitNorm){
			position=pos;  object=obj; distance=dist; hitNormal=hitNorm;
		}
		public Tuple3D getNormal() {
			return object.getNormalAt(position);
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
		
		public Tuple3D getHitNormal(){
			return hitNormal;
		}
	}
}