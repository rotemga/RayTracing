package RayTracing;

import java.util.List;

public class scene {
	private camera cam;
	private settings set;
	private List<material> mtl;
	private List<sphere> sph;
	private List<plane> pln;
	private List<cylinder> cyl;
	private List<light> lgt;
	public scene(camera cam, settings set, List<material> mtl, List<sphere> sph, List<plane> pln, List<cylinder> cyl,
			List<light> lgt) {
		super();
		this.cam = cam;
		this.set = set;
		this.mtl = mtl;
		this.sph = sph;
		this.pln = pln;
		this.cyl = cyl;
		this.lgt = lgt;
	}
	public camera getCam() {
		return cam;
	}
	public void setCam(camera cam) {
		this.cam = cam;
	}
	public settings getSet() {
		return set;
	}
	public void setSet(settings set) {
		this.set = set;
	}
	public List<material> getMtl() {
		return mtl;
	}
	public void setMtl(List<material> mtl) {
		this.mtl = mtl;
	}
	public List<sphere> getSph() {
		return sph;
	}
	public void setSph(List<sphere> sph) {
		this.sph = sph;
	}
	public List<plane> getPln() {
		return pln;
	}
	public void setPln(List<plane> pln) {
		this.pln = pln;
	}
	public List<cylinder> getCyl() {
		return cyl;
	}
	public void setCyl(List<cylinder> cyl) {
		this.cyl = cyl;
	}
	public List<light> getLgt() {
		return lgt;
	}
	public void setLgt(List<light> lgt) {
		this.lgt = lgt;
	}
}
