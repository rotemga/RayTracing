package RayTracing;

import javax.management.RuntimeErrorException;

public class Plane extends Object3D{
	private Tuple3D normal;
	private double offset;
	
	public Plane(Tuple3D normal, double offset, int material_index) {
		super(material_index);
		this.normal = normal.normalized();
		this.offset = offset;	
	}
	
	
	public Tuple3D getNormal() {
		return normal;
	}


	public void setNormal(Tuple3D normal) {
		this.normal = normal;
	}


	public double getOffset() {
		return offset;
	}
	
	public void setOffset(float offset) {
		this.offset = offset;
	}
	

	
	@Override
	public double getIntersection(Ray ray)
	{
		double denom = normal.dotFactor(ray.getDirection());
		if (Math.abs(denom) > 10E-10) 
		{
		    double t = (normal.scale(offset).sub(ray.getOrigin())).dotFactor(normal) / denom;
		    if (t > 0) return t; 
		}
		return -1;
	
		
		
	}
}