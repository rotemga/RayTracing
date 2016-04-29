package RayTracing;


public class Color {
	private final double R_VAL,G_VAL,B_VAL;
	
	public static byte toByte(double d){
		double bounded=Math.max(Math.min(1, d), 0);
		
		Long valueAsLong=new Long(Math.round(bounded*255)&0xff);
		return valueAsLong.byteValue();
		//return (new Long(Math.round(255*bounded))).byteValue();
		
	}
	
	public Color(double r,double g,double b){
		R_VAL=Math.min(Math.max(r, 0), 1);
		G_VAL=Math.min(Math.max(g, 0), 1);
		B_VAL=Math.min(Math.max(b, 0), 1);
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
		return new Color(R_VAL+other.R_VAL,G_VAL+other.G_VAL,B_VAL+other.B_VAL);
	}
	
	public Color sub(Color other){
		return new Color(R_VAL-other.R_VAL,G_VAL-other.G_VAL,B_VAL-other.B_VAL);
	}

	
	public double getR() {	return R_VAL;}
	public double getG() { return G_VAL;}
	public double getB() { return B_VAL; }

//	public void setR(int r_VAL) { R_VAL = r_VAL;}
//	public void setG(int g_VAL) { G_VAL = g_VAL; }
//	public void setB(int b_VAL) { B_VAL = b_VAL; }

	@Override
	public String toString(){
		return String.format("Color(%.3f,%.3f,%.3f)",R_VAL,G_VAL,B_VAL);
	}

	public Color mult(Color other) {
		return new Color(R_VAL*other.R_VAL,G_VAL*other.G_VAL,B_VAL*other.B_VAL);
	}
	
	
}