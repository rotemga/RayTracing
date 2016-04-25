package RayTracing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LightIntersection {

	Map<Light,Intersection> allLightsIntersections=new HashMap<Light,Intersection>();
	
	public LightIntersection(List<Light> lights,Tuple3D src,List<Object3D> allObjects){
		Ray tmpRay;
		Tuple3D tmpLightPos;
		for(Light light:lights){
			tmpLightPos=light.getPosition();
			tmpRay=new Ray(tmpLightPos,src.sub(tmpLightPos));
			allLightsIntersections.put(light, new Intersection(allObjects,tmpRay));
		}
	
	}
}