package RayTracing;

public class cylinder {
	private vector position;
	private double length;
	private double radius;
	private vector rotation;
	private int material_index;
	
	public int getMaterial_index() {
		return material_index;
	}

	public void setMaterial_index(int material_index) {
		this.material_index = material_index;
	}

	public cylinder(vector position, double length, double radius, vector rotation, int material_index) {
		super();
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
		this.material_index = material_index;
	}
	
	public vector getPosition() {
		return position;
	}
	public void setPosition(vector position) {
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
	public vector getRotation() {
		return rotation;
	}
	public void setRotation(vector rotation) {
		this.rotation = rotation;
	}
}
