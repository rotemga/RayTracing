package RayTracing;

import java.util.List;

public class Scene {
	private Camera cam;
	private Settings set;
	private List<Material> mtl;
	private List<Sphere> sph;
	private List<Plane> pln;
	private List<Cylinder> cyl;
	private List<Light> lgt;
	public Scene(Camera cam, Settings set, List<Material> mtl, List<Sphere> sph, List<Plane> pln, List<Cylinder> cyl,
			List<Light> lgt) {
		super();
		this.cam = cam;
		this.set = set;
		this.mtl = mtl;
		this.sph = sph;
		this.pln = pln;
		this.cyl = cyl;
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
	public List<Sphere> getSph() {
		return sph;
	}
	public void setSph(List<Sphere> sph) {
		this.sph = sph;
	}
	public List<Plane> getPln() {
		return pln;
	}
	public void setPln(List<Plane> pln) {
		this.pln = pln;
	}
	public List<Cylinder> getCyl() {
		return cyl;
	}
	public void setCyl(List<Cylinder> cyl) {
		this.cyl = cyl;
	}
	public List<Light> getLgt() {
		return lgt;
	}
	public void setLgt(List<Light> lgt) {
		this.lgt = lgt;
	}
}
