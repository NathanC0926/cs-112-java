package ps3;

public class ValuePair {
    private int a;
    private double b;

    public ValuePair(int a, double b) {
        setA(a);
        setB(b);
    }

    public double product() {
        return this.a * this.b;
    }

    public int getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public void setA(int a) {
        if (a % 2 == 1) {
            throw new IllegalArgumentException("a should be even");
        }
        this.a = a;
    }

    public void setB(double b) {
        if (b < 0) {
            throw new IllegalArgumentException("b should be non-negative");
        }
        this.b = b;
    }

}