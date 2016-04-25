package RayTracing;


public class Color {
	private double R_VAL,G_VAL,B_VAL;
	
	
	public Color(double r,double g,double b){
		R_VAL=(r > 1)? 1:r;
		G_VAL=(g > 1)? 1:g;
		B_VAL=(b > 1)? 1:b;
	}

	public Color(String rStr,String gStr,String bStr){
		this(Double.parseDouble(rStr),Double.parseDouble(gStr),Double.parseDouble(bStr));
	}
	
	public Color(Color c){
		this(c.R_VAL,c.G_VAL,c.G_VAL);
	}
	
	public Color scale(double scalar){
		return new Color(R_VAL*scalar,G_VAL*scalar,B_VAL*scalar);
	}
	public Color add(Color other){
		return new Color(R_VAL+other.R_VAL,G_VAL*other.G_VAL,B_VAL*other.B_VAL);
	}

	
	public double getR() {	return R_VAL;}
	public double getG() { return G_VAL;}
	public double getB() { return B_VAL; }

	public void setR(int r_VAL) { R_VAL = r_VAL;}
	public void setG(int g_VAL) { G_VAL = g_VAL; }
	public void setB(int b_VAL) { B_VAL = b_VAL; }


	
	
}