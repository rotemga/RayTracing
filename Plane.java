package RayTracing;

public class Plane extends Object3D{
	private Tuple3D normal;
	private float offset;
	
	public Plane(Tuple3D normal, float offset, int material_index) {
		super(material_index);
		this.normal = normal;
		this.offset = offset;	
	}
	
	
	public Tuple3D getNormal() {
		return normal;
	}


	public void setNormal(Tuple3D normal) {
		this.normal = normal;
	}


	public float getOffset() {
		return offset;
	}
	public void setOffset(float offset) {
		this.offset = offset;
	}
	

	
	@Override
	public double getIntersection(Ray ray)
	{
		double denom = normal.dotFactor(ray.getDirection());
		if (Math.abs(denom) > 10E-10f) 
		{
		    double t = (normal.sub(ray.getOrigin())).dotFactor(normal) / denom;
		    if (t >= 0) return t; 
		}
		return -1;

	}
}