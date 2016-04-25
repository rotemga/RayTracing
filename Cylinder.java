package RayTracing;

public class Cylinder extends Object3D{
	private Tuple3D position;
	private double length;
	private double radius;
	private Tuple3D rotation;
	
	

	public Cylinder(Tuple3D position, double length, double radius, Tuple3D rotation, int material_index) {
		super(material_index);
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
		
	}
	
	public Tuple3D getPosition() {
		return position;
	}
	public void setPosition(Tuple3D position) {
		this.position = position;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Tuple3D getRotation() {
		return rotation;
	}
	public void setRotation(Tuple3D rotation) {
		this.rotation = rotation;
	}
	
	@Override
	public double getIntersection(Ray ray)
	{
		
		
		double t0,t1;
		Tuple3D start = ray.getOrigin();
		Tuple3D direction = ray.getDirection();

		// a=xD2+yD2, b=2xExD+2yEyD, and c=xE2+yE2-1. 
		double a = direction.getX() * direction.getX()
			+ direction.getZ() * direction.getZ();

		double b = 2 * start.getX() * direction.getX()
			+ 2 * start.getZ() * direction.getZ();

		double c = start.getX() * start.getX()
			+ start.getZ() * start.getZ()
			- 1;

		double b24ac = b*b - 4*a*c;
		if (b24ac<0)
			return -1;
			
		double sqb24ac = Math.sqrt(b24ac);
		t0 = (-b + sqb24ac) / (2 * a);
		t1 = (-b - sqb24ac) / (2 * a);
		
		if (t0>t1) {double tmp = t0;t0=t1;t1=tmp;}

		double y0 = start.getY() + t0 * direction.getY();
		double y1 = start.getY() + t1 * direction.getY();
		
		
		
		if (y0<-1)
		{
			if (y1<-1)
				return -1;
			else
			{
				// hit the cap
				double th = t0 + (t1-t0) * (y0+1) / (y0-y1);
				if (th<=0) return -1;
			
//				out_Response.mHitPosition = start + (direction*th);
//				out_Response.mNormal = DVector3(0, -1, 0);
				return th;
			}
		}
		else if (y0>=-1 && y0<=1)
		{
			// hit the cylinder bit
			if (t0<=0) return -1;
				
//			out_Response.mHitPosition = start + (direction*t0);
//			out_Response.mNormal = DVector3(out_Response.mHitPosition.mComponent[0], 0, out_Response.mHitPosition.mComponent[2]);
//			out_Response.mNormal.Normalise();
		return t0;
		}
		else if (y0>1)
		{
			if (y1>1)
				return -1;
			else
			{
				// hit the cap
				double th = t0 + (t1-t0) * (y0-1) / (y0-y1);
				if (th<=0) return -1;

//				out_Response.mHitPosition = start + (direction*th);
//				out_Response.mNormal = DVector3(0, 1, 0);
				return th;
			}
		}

		return -1;
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Tuple3D direction	=	ray.getDirection(),
//				origin		=	ray.getOrigin(),
//				subtraction	=	origin.sub(position),
//				cross 		= 	ray.getDirection().cross(rotation),
//				tmp1 = null;
//		double d,s, t = 0,in,out;
//		
//		cross.normalized();
//		d =Math.abs(ray.getDirection().dotFactor(cross));
//		if (d<=radius){
//			 tmp1=origin.cross(rotation);
//			 tmp1.normalized();
//			 s=Math.abs( Math.sqrt(radius*radius-d*d) / direction.dotFactor(tmp1));
//			 t=-tmp1.dotFactor(cross)/3;
//			 in=t-s;
//			 out=t+s;
//			    if ((in<-10E-9)&&(out<-10E-9))
//			    {
//			    	return -1;
//			    }
//			    
//			    else{
//			    	return in;
//			    }
//		}

	}

}