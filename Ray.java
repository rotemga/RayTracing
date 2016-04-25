package RayTracing;

public class Ray {
	private Tuple3D origin;
	private Tuple3D direction;

    public Ray(Tuple3D position, Tuple3D Direction) {
        origin = new Tuple3D(position);
        if ((Direction.getX()!=0) || (Direction.getY()!=0) || (Direction.getZ()!=0)){
        	direction = Direction.normalized();
    }
        else{
        	direction = Direction;
        }
    }
    

    
//	public Ray constructRayThroughPixel(int i, int j, int width, int height, Camera Cam) {
//		Tuple3D look_at_point =  Cam.getLook_at_point();
//		Tuple3D Up =  Cam.getUp_vector();
//		Tuple3D cam_pos =   Cam.getPosition();
//		Tuple3D cam_right = look_at_point.mull(Up);
//		double normalized_i = (i / width) - 0.5;
//		double normalized_j = (j / height) - 0.5;
//		Tuple3D image_point = ((cam_right.scale(normalized_i).add(Up.scale(normalized_j))).add(cam_pos)).add(look_at_point);
//		Tuple3D ray_direction = image_point.sub(cam_pos);
//
//		return new Ray(cam_pos, ray_direction);
//	}
//	
//	public Ray constructRayThroughPixel(int i, int j, int width, int height, Camera Cam) {
//		double xDir = (j - width / 2f);
//		double yDir = (i - height / 2f);
//		double zDir = (double) (
//				Math.min(width, height)
//				/ (2 * Math.tan(scene.getCamera().fieldOfView / 2)));
//		Vector4d dir = new Vector4d(xDir, -yDir, -zDir, 1);
//		dir.normalize();
//		Vector4d result = Util.MultiplyMatrixAndVector(scene.getCamera().rotationMatrix,
//				dir);
//		Vector3d direction = new Vector3d(result.x, result.y, result.z);
//		direction.normalize();
//		return new Ray(scene.getCamera().position, direction);
//	}

	public Tuple3D getOrigin() {
		return origin;
	}

	public void setOrigin(Tuple3D origin) {
		this.origin = origin;
	}

	public Tuple3D getDirection() {
		return direction;
	}

	public void setDirection(Tuple3D direction) {
		this.direction = direction;
	}
    
    


}