package RayTracing;


public class sphere {

	private vector position;
	private int raduis;
	
	public sphere(vector position, int raduis) {
		super();
		this.position = position;
		this.raduis = raduis;
	}
	public vector getPosition() {
		return position;
	}
	public void setPosition(vector position) {
		this.position = position;
	}
	public int getRaduis() {
		return raduis;
	}
	public void setRaduis(int raduis) {
		this.raduis = raduis;
	}
}
