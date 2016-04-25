package RayTracing;


public class Sphere extends Object3D{

	private Tuple3D position_center;
	private double radius;
	
	public Sphere(Tuple3D  position_center, double radius, int material_index) {
		super(material_index);
		this.position_center =  position_center;
		this.radius = radius;

	}

	public Tuple3D getPosition() {
		return  position_center;
	}

	public void setPosition(Tuple3D  position_center) {
		this.position_center =  position_center;
	}

	public double getRaduis() {
		return radius;
	}

	public void setRaduis(double raduis) {
		this.radius = raduis;
	}
	
	
	@Override
	public double getIntersection(Ray ray)
	{
		/*
		Tuple3D v = new Tuple3D(ray.getOrigin());
		v.sub(position_center);
	    double b = 2 * ray.getDirection().dotFactor(v);
	    double c = v.dotFactor(v) - radius * radius;
	    double d = b * b - 4 * c;
	    
	
	    if(d > 0)
	    {
	    	
	        double x1 = (-b - Math.sqrt(d)) / 2;
	        double x2 = (-b + Math.sqrt(d)) / 2;
	        if(x1 >= 0 && x2 >= 0) return x1;
	        if(x1 < 0 && x2 >= 0) return x2;
	    }*/
		Tuple3D direction	=	ray.getDirection(),
				origin		=	ray.getOrigin(),
				subtraction	=	origin.sub(position_center);
	    
		// solving ad^2 +bd +c
	    double 	a= direction.dotFactor(direction),
	    		b= 2*direction.dotFactor(subtraction),
	    		c= subtraction.dotFactor(subtraction)-radius*radius;
	    
	    double delta=b*b-4*a*c;
	    if(delta<0) return -1;
	    
	    
	    double sqrtDelta=Math.sqrt(delta);
	    double solution1=(-b-sqrtDelta)/(2*a);
	    double solution2=(-b+sqrtDelta)/(2*a);
	    
	    return (solution1>0)?solution1:(solution2>0)?solution2:-1;
	}
	
	@Override
	public String toString(){
		return String.format("Sphere : (center:%s,radius:%f)\n", this.position_center,this.radius);
	}
}	
//	@Override
//	public Intersection intersectsRay(Ray ray) {
//		Tuple3D aux = new Tuple3D(ray.getOrigin());
//		aux.sub(position_center);
//		double a = 1.0; // == ray.direction.dot(ray.direction);
//		double b = 2 * (ray.getDirection().dotFactor(aux));
//		double c = Math.pow(aux.norm(), 2) - Math.pow(radius, 2);
//
//		double discriminant = Math.pow(b, 2) - 4 * a * c;
//		if (discriminant < 0) {
//			return null;
//		}
//
//		double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
//		double t2 = (-b - Math.sqrt(discriminant)) / (2 * a);
//		double t;
//
//		if (t1 < 0 && t2 < 0) {
//			return null;
//		} else if (t1 < 0) {
//			t = t2;
//		} else if (t2 < 0) {
//			t = t1;
//		} else if (Math.abs(t1) < Math.abs(t2)) {
//			t = t1;
//		} else {
//			t = t2;
//		}
//		
//		Tuple3D point = new Tuple3D(ray.getDirection());
//		point.scale(t);
//		point.add(ray.getOrigin());	
//		Tuple3D normal = (point).normalized();
//		double distance = t;
//
//		//Intersection x = new Intersection(point,normal,distance);
//		Intersection x = new Intersection(this,distance);
//
//		return x;
//	}
	
	//return -1 if there is no hit


//    public boolean intersect(Ray ray) {
//        double dx = position_center.getX() - ray.getOrigin().getX();
//        double dy = position_center.getY() - ray.getOrigin().getY();
//        double dz = position_center.getZ() - ray.getOrigin().getZ();
//        double v = ray.getDirection().dotFactor(new Tuple3D(dx,dy,dz));
//
//        // Do the following quick check to see if there is even a chance
//        // that an intersection here might be closer than a previous one
//        if (v - radius > ray.t)
//            return false;
//
//        // Test if the ray actually intersects the sphere
//        float t = radSqr + v*v - dx*dx - dy*dy - dz*dz;
//        if (t < 0)
//            return false;
//
//        // Test if the intersection is in the positive
//        // ray direction and it is the closest so far
//        t = v - ((float) Math.sqrt(t));
//        if ((t > ray.t) || (t < 0))
//            return false;
//
//        ray.t = t;
//        ray.object = this;
//        return true;
//    }





//public double Intersect(Tuple3D R0, Tuple3D R1, Sphere sph) {
//
//	double t,          /* where the ray intersects */
//	    loc,        /* square distance from center of sphere to projP */
//	    tca,        /* how far is the 'closest approach' from VRP */   
//	    thc;        /* length sqare of the half chord */
//	Tuple3D vecoc;      /* vector to the center of the sphere from VRP */
//	boolean inside=false;
//
//	/* use the closest approach algorithm */
//	vecoc = new Tuple3D(sph.getPosition());
//	vecoc.sub(R0);
//	loc = vecoc.dotFactor(vecoc);
//
//	if(loc <= sph.getRaduis())
//	    inside = true;
//
//	tca = vecoc.dotFactor(R1);   /* find the closest approach */
//
//	if ((inside != true) && (tca <= 0.0))
//	    return(0.0);  /* object is behind the VRP */
//
//	/* compute the half chord square from the ray intersection to the 
//	   intersection normal. */
//	thc = (tca * tca) + sph.getRaduis() - loc;
//	if (thc < 0.0)
//	    return(0.0);   /* ray misses the sphere */
//
//	/* find the ray intersection */
//	if (inside == true)
//	    t = tca + Math.sqrt(thc);
//	else
//	    t = tca - Math.sqrt(thc);
//
//	return(t);
//}
