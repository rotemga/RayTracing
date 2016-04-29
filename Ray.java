package RayTracing;

public class Ray {
	private Tuple3D origin;
	private Tuple3D direction;
	private Tuple3D closestDist;





	public Ray(Tuple3D position, Tuple3D Direction) {
        origin = new Tuple3D(position);
        if ((Direction.getX()!=0) || (Direction.getY()!=0) || (Direction.getZ()!=0)){
        	direction = Direction.normalized();
    }
        else{
        	direction = Direction;
        }
    }
    


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
    public Tuple3D getClosestDist() {
		return closestDist;
	}



	public void setClosestDist(Tuple3D closestDist) {
		this.closestDist = closestDist;
	}
	

	@Override
	public String toString(){
		return "Ray: "+origin+"->"+direction;
	}


    public Tuple3D getLocationAtTime(double time){
    	return direction.scale(time).add(origin);
    }
    


}