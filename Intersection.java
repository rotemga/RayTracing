package RayTracing;

import java.util.List;

public class Intersection {


	
	private List<Object3D> objects;
	private List<Double> distances;
	private Ray ray;


	public Intersection(List<Object3D> primitives, List<Double> distances, Ray ray) {
		this.objects = primitives;
		this.distances = distances;
		this.ray = ray;
	}





	public Ray getRay() {
		return ray;
	}





	public void setRay(Ray ray) {
		this.ray = ray;
	}





	public List<Object3D> getObjects() {
		return objects;
	}





	public void setObjects(List<Object3D> objects) {
		this.objects = objects;
	}





	public List<Double> getDistances() {
		return distances;
	}





	public void setDistances(List<Double> distances) {
		this.distances = distances;
	}





	public Intersection() {
		super();
	}

//	Intersection FindIntersection(Ray ray, Scene scene)
//	{
//		List<Object3D> objects = scene.getObjects();
//		int min_t = -100000;
//		int t;
//		Object3D min_primitive = null;
//		for (int i=0; i< objects.size();i++) {
//			t = Intersect(ray, objects.get(i));
//		if (t < min_t)
//		min_primitive = objects.get(i);
//		min_t = t;
//		}
//	
//		return Intersection(min_t, min_primitive);
//}

	

    
}
