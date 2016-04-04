package RayTracing;

public class plane {
	private vector normal;
	private int offset;
	private int material_index;
	public plane(vector normal, int offset, int material_index) {
		super();
		this.normal = normal;
		this.offset = offset;
		this.material_index = material_index;
	}
	public vector getNormal() {
		return normal;
	}
	public void setNormal(vector normal) {
		this.normal = normal;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getMaterial_index() {
		return material_index;
	}
	public void setMaterial_index(int material_index) {
		this.material_index = material_index;
	}
	

	
}
