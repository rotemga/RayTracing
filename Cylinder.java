package RayTracing;

public class Cylinder {
	private Point position;
	private double length;
	private double radius;
	private Point rotation;
	private int material_index;
	
	public int getMaterial_index() {
		return material_index;
	}

	public void setMaterial_index(int material_index) {
		this.material_index = material_index;
	}

	public Cylinder(Point position, double length, double radius, Point rotation, int material_index) {
		super();
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
		this.material_index = material_index;
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
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
	public Point getRotation() {
		return rotation;
	}
	public void setRotation(Point rotation) {
		this.rotation = rotation;
	}
}
