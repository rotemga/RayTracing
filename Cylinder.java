package RayTracing;

public class Cylinder extends Object3D{
	private Tuple3D position;
	private double length;
	private double radius;
	private Tuple3D rotation;
	
	private NiceCylinder niceCylVersion;

	public Cylinder(Tuple3D position, double length, double radius, Tuple3D rotation, int material_index) {
		super(material_index);
		this.position = position;
		this.length = length;
		this.radius = radius;
		this.rotation = rotation;
		niceCylVersion= new NiceCylinder(this);
	}
	
	public Tuple3D getPosition() {
		return position;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getRadius() {
		return radius;
	}
	
	
	public Tuple3D getRotation() {
		return rotation;
	}
	
	private Tuple3D deRotate(Tuple3D point){
		double rx=rotation.getX(),ry=rotation.getY(),rz=rotation.getZ();
		return point.rotateZ(-rz).rotateY(-ry).rotateX(-rx);
	}
	
	
	
	private Ray adjustedRay(Ray original){
		Tuple3D origin=deRotate(original.getOrigin().sub(position));
		Tuple3D direction=deRotate(original.getDirection());
		return new Ray(origin, direction);
	}
	
	@Override
	public double getIntersection(Ray ray)
	{
		
		Ray adjustedRay =adjustedRay(ray);
		return niceCylVersion.intersect(adjustedRay);
		
		//return niceIntersection(ray);
		/*
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
		
*/
		
		
		
		
		
		
		
		
		
		
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
	
	/**
	 * cylinder with position 0,0,0 and rotation 0,0,0 
	 * (assumed default axis is y... may not be true)
	 * */
	private class NiceCylinder{  
		private double length;
		private double radius;
		 
		
		
		public NiceCylinder(Cylinder origin){
			length=origin.length;
			radius=origin.radius;
		}
		
		public double intersect(Ray ray){
			//had a little problem... initialy assumed default cyl-axis is Y, 
			//turned up to be Z, had difficulties converting to Z, so just rotated the ray again 
			Ray rayYtoZ=new Ray(ray.getOrigin().rotateX(-90),ray.getDirection().rotateX(-90));
			double bodyIntersection=intersectBodyY(rayYtoZ);
			double capsIntersection=intersectCapsY(rayYtoZ);
			
			if(bodyIntersection>0 && capsIntersection>0){
				return Math.min(bodyIntersection, capsIntersection);
			}
			if(bodyIntersection>0) return bodyIntersection;
			if(capsIntersection>0) return capsIntersection;
			return -1;
				
		}
		
		private double intersectBodyY(Ray ray){
			Tuple3D origPos=ray.getOrigin(),origDir=ray.getDirection();
			
			Tuple3D projPos=new Tuple3D(origPos.getX(),0,origPos.getZ()),
					projDir=new Tuple3D(origDir.getX(),0,origDir.getZ());
			
			//getting 0,1 or 2 intersection with flattened circle (0,0 on (x,z) plane)
			//solving quadric equation:
			double a=projDir.dotFactor(projDir);
			double b=2* projDir.dotFactor(projPos);
			double c=projPos.dotFactor(projPos)-radius*radius;
			
			double delta = b*b - 4*a*c;

			if (delta>0) {
				double sqrtDelta=Math.sqrt(delta);
				
				double entranceDist2D=(-b-sqrtDelta)/(2*a);
				//double exitDist2D=(-b+sqrtDelta)/(2*a);
				
				//getting actual distances using Pythagoras's theorem 
				double origDirY=origDir.getY();
				double entranceDist3D=Math.sqrt(entranceDist2D*entranceDist2D+origDirY*origDirY);
				//double exitDist3D=Math.sqrt(exitDist2D*exitDist2D+origDirY*origDirY);
				
				double origPosY=origPos.getY();
				double entranceY = origPosY+entranceDist3D*origDirY;
				//double exitY = origPosY+exitDist3D*origDirY;
				
				//entering to one of the cyl's "sides"
				if(entranceY<=length/2 && entranceY>=-(length/2)){
					return entranceDist3D;
				}
			}
			return -1;
		}
		
		private double intersectCapsY(Ray ray){
			Plane upperCapPlane = new Plane(new Tuple3D(0,1,0), length/2, 1/*material doesn't matter*/);
			Plane buttomCapPlane = new Plane(new Tuple3D(0,-1,0), length/2, 1/*material doesn't matter*/);
			
			double upperIntersection = upperCapPlane.getIntersection(ray);
			double buttomIntersection = buttomCapPlane.getIntersection(ray);
			
			
			boolean isUpperLegal = (upperIntersection>0) && 
									checkInCircleY(ray.getLocationAtTime(upperIntersection)); 
			boolean isButtomLegal = (upperIntersection>0) && 
					checkInCircleY(ray.getLocationAtTime(buttomIntersection));
			
			if(isUpperLegal && isButtomLegal){
				return Math.min(upperIntersection, buttomIntersection);
			}
			if(isUpperLegal) return upperIntersection;
			if(isButtomLegal) return buttomIntersection;
			return -1;
			
		}
		private boolean checkInCircleY(Tuple3D point){
			Tuple3D projY= new Tuple3D(point.getX(),0,point.getZ());
			return projY.dotFactor(projY)<radius*radius;
		}
		
		

		
	}
	
}