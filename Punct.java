package Laborator3;

public class Punct {
    private  int x;
    private  int y;
    public Punct(double x, double y) {
        super();
        this.x = (int) x;
        this.y = (int) y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
