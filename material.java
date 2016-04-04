package RayTracing;

class material {
	private vector diffuse_col;
	private vector specular_col;
	private float phong_specular_coeff;
	private vector reflection_col;
	private double transparency;
	
	public material(vector diffuse_col, vector specular_col, float phong_specular_coeff, vector reflection_col,
			double transparency) {
		super();
		this.diffuse_col = diffuse_col;
		this.specular_col = specular_col;
		this.phong_specular_coeff = phong_specular_coeff;
		this.reflection_col = reflection_col;
		this.transparency = transparency;
	}
	public vector getDiffuse_col() {
		return diffuse_col;
	}
	public void setDiffuse_col(vector diffuse_col) {
		this.diffuse_col = diffuse_col;
	}
	public vector getSpecular_col() {
		return specular_col;
	}
	public void setSpecular_col(vector specular_col) {
		this.specular_col = specular_col;
	}
	public float getPhong_specular_coeff() {
		return phong_specular_coeff;
	}
	public void setPhong_specular_coeff(float phong_specular_coeff) {
		this.phong_specular_coeff = phong_specular_coeff;
	}
	public vector getReflection_col() {
		return reflection_col;
	}
	public void setReflection_col(vector reflection_col) {
		this.reflection_col = reflection_col;
	}
	public double getTransparency() {
		return transparency;
	}
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

}
