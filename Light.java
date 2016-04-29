package RayTracing;


public class Light {
	private Tuple3D position;
	private Color color;
	private float specular_intensity;
	private float shadow_intensity;
	private float radius;
	private float[] attenuation = new float[] { 1, 0, 0 };

	public Light(Tuple3D position, Color color, float specular_intensity, float shadow_intensity, float radius) {
		super();
		this.position = position;
		this.color = color;
		this.specular_intensity = specular_intensity;
		this.shadow_intensity = shadow_intensity;
		this.radius = radius;
	}
	public Tuple3D getPosition() {
		return position;
	}
	public void setPosition(Tuple3D position) {
		this.position = position;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public float getSpecular_intensity() {
		return specular_intensity;
	}
	public void setSpecular_intensity(float specular_intensity) {
		this.specular_intensity = specular_intensity;
	}
	public float getShadow_intensity() {
		return shadow_intensity;
	}
	public void setShadow_intensity(float shadow_intensity) {
		this.shadow_intensity = shadow_intensity;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public Color getColor(Tuple3D currentPosition) {
		double r = Math.sqrt(Math.pow(position.getX() - currentPosition.getX(), 2.0)
				+ Math.pow(position.getY() - currentPosition.getY(), 2.0)
				+ Math.pow(position.getZ() - currentPosition.getZ(), 2.0));
		double factor = 1 / Math.max(attenuation[0] + attenuation[1] * r
				+ attenuation[2] * r * r, 1);

		Color result = new Color(color);
		result.scale(factor);
		return result;
		//return new Tuple3D(color);
	}
	

}