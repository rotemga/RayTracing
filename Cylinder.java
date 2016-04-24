package RayTracing;

public class Cylinder extends Object3D{
	private Tuple3D position;
	private double length;
	private double radius;
	private Tuple3D rotation;
	
	

	public Cylinder(Tuple3D position, double length, double radius, Tuple3D rotation, int material_index) {
		super(material_index);
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
		
	}
	
	public Tuple3D getPosition() {
		return position;
	}
	public void setPosition(Tuple3D position) {
		this.position = position;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Tuple3D getRotation() {
		return rotation;
	}
	public void setRotation(Tuple3D rotation) {
		this.rotation = rotation;
	}
	
	@Override
	public double getIntersection(Ray ray)
	{

	    return -1;
	}
}