package RayTracing;

public class plane {
	private vector N;
	private int offset;
	
	public vector getN() {
		return N;
	}

	public void setN(vector n) {
		N = n;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public plane(vector n, int offset) {
		super();
		N = n;
		this.offset = offset;
	}
	
}
