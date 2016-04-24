package RayTracing;

import java.util.Map;
import java.util.HashMap;



class Material {
	private Color diffuse_col;
	private Color specular_col;
	private Color reflection_col;
	
	private float phong_specular_coeff;
	private float transparency;
	
	private static Map<Integer, Material> idx_to_material = new HashMap<Integer, Material>();
	private static int nextMaterialIndex=0;
	
	public static Material getByIndex(int index){
		return idx_to_material.get(index);
	}
	
		
	public Material(
			Color diffuse_col, Color specular_col, float phong_specular_coeff, Color reflection_col,
			float transparency) 
	{
		this.diffuse_col = diffuse_col;
		this.specular_col = specular_col;
		this.phong_specular_coeff = phong_specular_coeff;
		this.reflection_col = reflection_col;
		this.transparency = transparency;
		
		idx_to_material.put(++nextMaterialIndex, this);
	}
	
	public Color getDiffuse_col() {
		return diffuse_col;
	}
	public void setDiffuse_col(Color diffuse_col) {
		this.diffuse_col = diffuse_col;
	}
	public Color getSpecular_col() {
		return specular_col;
	}
	public void setSpecular_col(Color specular_col) {
		this.specular_col = specular_col;
	}
	public float getPhong_specular_coeff() {
		return phong_specular_coeff;
	}
	public void setPhong_specular_coeff(float phong_specular_coeff) {
		this.phong_specular_coeff = phong_specular_coeff;
	}
	public Color getReflection_col() {
		return reflection_col;
	}
	public void setReflection_col(Color reflection_col) {
		this.reflection_col = reflection_col;
	}
	public float getTransparency() {
		return transparency;
	}
	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}

}