package RayTracing;

public abstract class Object3D {
	
	private Material material;
	private int material_index;
	
	public Object3D(int materialIdx){
		material_index = materialIdx;
		material=Material.getByIndex(materialIdx);
		if(material==null) throw new RuntimeException("unrecognized material index");
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	//public abstract Intersection intersectsRay(Ray ray);
	
	public abstract double getIntersection(Ray ray);

	public abstract Tuple3D getNormalAt(Tuple3D point);
	
	
}