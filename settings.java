package RayTracing;

public class settings {
	private vector backgrouad_col;
	private int num_shadow_rays;
	private int max_num_recurstion;
	
	public vector getBackgrouad_col() {
		return backgrouad_col;
	}
	public void setBackgrouad_col(vector backgrouad_col) {
		this.backgrouad_col = backgrouad_col;
	}
	public int getNum_shadow_rays() {
		return num_shadow_rays;
	}
	public void setNum_shadow_rays(int num_shadow_rays) {
		this.num_shadow_rays = num_shadow_rays;
	}
	public int getMax_num_recurstion() {
		return max_num_recurstion;
	}
	public void setMax_num_recurstion(int max_num_recurstion) {
		this.max_num_recurstion = max_num_recurstion;
	}
	public settings(vector backgrouad_col, int num_shadow_rays, int max_num_recurstion) {
		super();
		this.backgrouad_col = backgrouad_col;
		this.num_shadow_rays = num_shadow_rays;
		this.max_num_recurstion = max_num_recurstion;
	}
}
