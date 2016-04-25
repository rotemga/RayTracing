package RayTracing;

public class Tuple3D{
		
	private double x,y,z;
	
	private void set(double x, double y, double z){
		this.x=x;	this.y=y;	this.z=z;
	}
	
	public Tuple3D(double x, double y, double z) {
		set(x,y,z);
	}
	

	
	public Tuple3D(String xStr, String yStr, String zStr) {
		this(Double.parseDouble(xStr),Double.parseDouble(yStr),Double.parseDouble(zStr));
	}
	public Tuple3D(Tuple3D other) {
		this(other.getX(),other.getY(),other.getZ());
	}
	
	public Tuple3D(Tuple3D other,Tuple3D origin) {
		this(other.sub(origin));
	}
	
	
    public Tuple3D cross(Tuple3D B) {
        return new Tuple3D(this.y*B.z - this.z*B.y, this.z*B.x - this.x*B.z, this.x*B.y - this.y*B.x);
    }
	
    public Tuple3D mull(Tuple3D other) {
        return new Tuple3D(this.x*other.getX(), this.y*other.getY(), this.z*other.getZ());
    }
    
	public double getX() { return x; }
	public double getY() { return y; }
	public double getZ() { return z; }
	

	public Tuple3D sub(Tuple3D origin) {
		return new Tuple3D(add(origin.scale(-1)));
	}
	


	public Tuple3D add(Tuple3D other) {
		return new Tuple3D(x+other.getX(),y+other.getY(),z+other.getZ());
	}
	
	public Tuple3D scale(double scalar) {
		return new Tuple3D(x*scalar,y*scalar,z*scalar);
	}
	
	public double dotFactor(Tuple3D tuple3d){
		return x*tuple3d.getX()+y*tuple3d.getY()+z*tuple3d.getZ();
	}
	
	public double norm() {
		return Math.sqrt(dotFactor(this));	
	}
	
	public void normalize() {
		double norm=norm();
		if (norm == 0.0) throw new RuntimeException("Zero-vector has no direction");
		set(x/norm,y/norm,z/norm);
	}
	
	public Tuple3D normalized() {
		Tuple3D result = new Tuple3D(this);
		result.normalize();
		return result;
	}
	
	public double distance(Tuple3D other) {
		return sub(other).norm();
	}
	
	@Override
	public String toString(){return String.format("(%.4f,%.4f,%.4f)", x,y,z);}
}