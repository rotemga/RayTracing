package RayTracing;


public class Sphere {

	private Point position;
	private double raduis;
	private int material_index;
	public Sphere(Point position, double raduis, int material_index) {
		super();
		this.position = position;
		this.raduis = raduis;
		this.material_index = material_index;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public double getRaduis() {
		return raduis;
	}
	public void setRaduis(double raduis) {
		this.raduis = raduis;
	}
	public int getMaterial_index() {
		return material_index;
	}
	public void setMaterial_index(int material_index) {
		this.material_index = material_index;
	}
	

}
