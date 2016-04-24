package RayTracing;

public class Settings {
	private Color backgrouad_col;
	private int root_num_shadow_rays;
	private int max_num_recurstion;
		
	public Settings(Color backgrouad_col, int root_num_shadow_rays, int max_num_recurstion) {
		this.backgrouad_col = backgrouad_col;
		this.root_num_shadow_rays = root_num_shadow_rays;
		this.max_num_recurstion = max_num_recurstion;
	}
	
	public Color getBackgrouad_col() {
		return backgrouad_col;
	}
	public void setBackgrouad_col(Color backgrouad_col) {
		this.backgrouad_col = backgrouad_col;
	}
	
	public int getroot_root_root_num_shadow_rays() {
		return root_num_shadow_rays;
	}
	public void setroot_root_root_num_shadow_rays(int root_num_shadow_rays) {
		this.root_num_shadow_rays = root_num_shadow_rays;
	}
	public int getMax_num_recurstion() {
		return max_num_recurstion;
	}
	public void setMax_num_recurstion(int max_num_recurstion) {
		this.max_num_recurstion = max_num_recurstion;
	}
	
}