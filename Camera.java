package RayTracing;


public class Camera {
	private Tuple3D position;
	private Tuple3D look_at_point;
	private Tuple3D up_vector;
	private float screen_distance;
	private float screen_width;

	
	
	public Camera(Tuple3D position, Tuple3D look_at_point, Tuple3D up_vector, float screen_distance,float screen_width) {
		super();
		this.position = position;
		this.look_at_point = look_at_point;
		this.up_vector = up_vector;
		this.screen_distance = screen_distance;
		this.screen_width = screen_width;

	}



	public Tuple3D getPosition() {
		return position;
	}


	public void setPosition(Tuple3D position) {
		this.position = position;
	}


	public Tuple3D getLook_at_point() {
		return look_at_point;
	}


	public void setLook_at_point(Tuple3D look_at_point) {
		this.look_at_point = look_at_point;
	}


	public Tuple3D getUp_vector() {
		return up_vector;
	}


	public void setUp_vector(Tuple3D up_vector) {
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


	
	
}