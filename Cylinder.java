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
	
	private Tuple3D reRotate(Tuple3D point){
		double rx=rotation.getX(),ry=rotation.getY(),rz=rotation.getZ();
		return point.rotateX(rx).rotateY(ry).rotateZ(rz);
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
	}
	
	@Override
	public Tuple3D getNormalAt(Tuple3D point) {

		return reRotate(niceCylVersion.getNormalAt(deRotate(point.sub(this.position))));
		
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
		
		
		public Tuple3D getNormalAt(Tuple3D point) {
			
			
			Tuple3D zProjection= new Tuple3D(point.getX(),point.getY(),0);
			double distanceFromCenter =Math.abs(zProjection.dotFactor(zProjection)-radius*radius);
			double distanceFromUpCap=Math.abs(point.getZ() -  length/2);
			double distanceFromButtomCap=Math.abs(point.getZ() +  length/2);
			
			
			if(distanceFromCenter<=distanceFromUpCap){
				if(distanceFromCenter<=distanceFromButtomCap){
					
					return zProjection.normalized();
				}
			}
			else if(distanceFromUpCap<=distanceFromButtomCap){
				
				return new Tuple3D(0,0,1);
			}

			return new Tuple3D(0,0,-1);
				

			
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