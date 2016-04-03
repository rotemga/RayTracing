package RayTracing;

class material {
	private double diffuse_col;
	private double specular_col;
	private float phong_specular_coeff;
	private double reflection_col;
	private double transparency;
	
	public material(double diffuse_col, double specular_col, float phong_specular_coeff, double reflection_col,
			double transparency) {
		super();
		this.diffuse_col = diffuse_col;
		this.specular_col = specular_col;
		this.phong_specular_coeff = phong_specular_coeff;
		this.reflection_col = reflection_col;
		this.transparency = transparency;
	}
	public double getDiffuse_col() {
		return diffuse_col;
	}
	public void setDiffuse_col(double diffuse_col) {
		this.diffuse_col = diffuse_col;
	}
	public double getSpecular_col() {
		return specular_col;
	}
	public void setSpecular_col(double specular_col) {
		this.specular_col = specular_col;
	}
	public float getPhong_specular_coeff() {
		return phong_specular_coeff;
	}
	public void setPhong_specular_coeff(float phong_specular_coeff) {
		this.phong_specular_coeff = phong_specular_coeff;
	}
	public double getReflection_col() {
		return reflection_col;
	}
	public void setReflection_col(double reflection_col) {
		this.reflection_col = reflection_col;
	}
	public double getTransparency() {
		return transparency;
	}
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

}
