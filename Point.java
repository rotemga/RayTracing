package RayTracing;
//http://introcs.cs.princeton.edu/java/34nbody/Vector.java.html
public class Point {

    private final int N;         // length of the vector
    private double[] data;       // array of vector's components

    // create the zero vector of length N
    public Point(int N) {
        this.N = N;
        this.data = new double[N];
    }

    // create a vector from an array
    public Point(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++)
            this.data[i] = data[i];
    }
    public Point(String[] data){
        N = data.length;
        this.data = new double[N];
		for (int i = 0; i < N; i++) {
			double tmp = Double.parseDouble(data[i]);
		    this.data[i] = tmp;
		}
		
    }


    // return the length of the vector
    public int length() {
        return N;
    }

    // return the inner product of this vector a and b
    public double dot(Point that) {
        if (this.length() != that.length()) throw new RuntimeException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    // return the Euclidean norm of this vector
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    // return the Euclidean distance between this and that
    public double distanceTo(Point that) {
        if (this.length() != that.length()) throw new RuntimeException("Dimensions don't agree");
        return this.minus(that).magnitude();
    }

    // return this + that
    public Point plus(Point that) {
        if (this.length() != that.length()) throw new RuntimeException("Dimensions don't agree");
        Point c = new Point(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    // return this - that
    public Point minus(Point that) {
        if (this.length() != that.length()) throw new RuntimeException("Dimensions don't agree");
        Point c = new Point(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }

    // return the corresponding coordinate
    public double cartesian(int i) {
        return data[i];
    }

    // create and return a new object whose value is (this * factor)
    public Point times(double factor) {
        Point c = new Point(N);
        for (int i = 0; i < N; i++)
            c.data[i] = factor * data[i];
        return c;
    }


    // return the corresponding unit vector
    public Point direction() {
        if (this.magnitude() == 0.0) throw new RuntimeException("Zero-vector has no direction");
        return this.times(1.0 / this.magnitude());
    }

    // return a string representation of the vector
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < N; i++) {
            s.append(data[i]);
            if (i < N-1) s.append(", ");
        }
        s.append(")");
        return s.toString();
    }}
