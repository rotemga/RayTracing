package RayTracing;

import java.util.List;

public class Scene {
	private Camera cam;
	private Settings set;
	private List<Material> mtl;
	private List<Object3D> objects;
	private List<Light> lgt;
	public Scene(Camera cam, Settings set, List<Material> mtl, List<Object3D> objects,List<Light> lgt) {
		this.cam = cam;
		this.set = set;
		this.mtl = mtl;
		this.objects=objects;
		this.lgt = lgt;
	}
	public Camera getCam() {
		return cam;
	}
	public void setCam(Camera cam) {
		this.cam = cam;
	}
	public Settings getSet() {
		return set;
	}
	public void setSet(Settings set) {
		this.set = set;
	}
	public List<Material> getMtl() {
		return mtl;
	}
	public void setMtl(List<Material> mtl) {
		this.mtl = mtl;
	}
	
	public List<Object3D> getObjects() {
		return objects;
	}
	public void setObjects(List<Object3D> objects) {
		this.objects = objects;
	}
	public List<Light> getLgt() {
		return lgt;
	}
	public void setLgt(List<Light> lgt) {
		this.lgt = lgt;
	}
}