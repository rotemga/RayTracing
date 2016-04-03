package RayTracing;


public class camera {
	private vector position;
	private vector look_at_point;
	private vector up_vector;
	private float screen_distance;
	private float screen_width;
	private double background_col;
	private int num_shadow_rays;
	private int max_recursion_level;
	
	public camera(vector position, vector look_at_point, vector up_vector, float screen_distance,
			float screen_width) {
		super();
		this.position = position;
		this.look_at_point = look_at_point;
		this.up_vector = up_vector;
		this.screen_distance = screen_distance;
		this.screen_width = screen_width;

	}
	public vector getPosition() {
		return position;
	}
	public void setPosition(vector position) {
		this.position = position;
	}
	public vector getLook_at_point() {
		return look_at_point;
	}
	public void setLook_at_point(vector look_at_point) {
		this.look_at_point = look_at_point;
	}
	public vector getUp_vector() {
		return up_vector;
	}
	public void setUp_vector(vector up_vector) {
		this.up_vector = up_vector;
	}
	public float getScreen_distance() {
		return screen_distance;
	}
	public void setScreen_distance(float screen_distance) {
		this.screen_distance = screen_distance;
	}
	public float getScreen_width() {
		return screen_width;
	}
	public void setScreen_width(float screen_width) {
		this.screen_width = screen_width;
	}
	public double getBackground_col() {
		return background_col;
	}
	public void setBackground_col(double background_col) {
		this.background_col = background_col;
	}
	public int getNum_shadow_rays() {
		return num_shadow_rays;
	}
	public void setNum_shadow_rays(int num_shadow_rays) {
		this.num_shadow_rays = num_shadow_rays;
	}
	public int getMax_recursion_level() {
		return max_recursion_level;
	}
	public void setMax_recursion_level(int max_recursion_level) {
		this.max_recursion_level = max_recursion_level;
	}

	
}
