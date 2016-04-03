package RayTracing;

public class cylinder {
	private vector position;
	private int length;
	private int radius;
	private vector rotation;
	
	public cylinder(vector position, int length, int radius, vector rotation) {
		super();
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
	}
	
	public vector getPosition() {
		return position;
	}
	public void setPosition(vector position) {
		this.position = position;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public vector getRotation() {
		return rotation;
	}
	public void setRotation(vector rotation) {
		this.rotation = rotation;
	}
}
