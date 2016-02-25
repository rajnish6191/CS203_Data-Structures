package Assignment3;

public class Hilbert {
    private static double x = 0.0, y = 0.0;
    private static double dimension = 0.0;
    public static void rotate(double angle) {
        dimension += angle;
    }
    
    public static void forward(double d) {
        double x0 = x, y0 = y;
        x += d * Math.cos(Math.toRadians(dimension));
        y += d * Math.sin(Math.toRadians(dimension));
        Assignment3.line(x0, y0, x, y);
    }

    public static void hilbert0(int n) {
        if (n == 0) return;
        rotate(90);
        hilbert1(n-1);
        forward(1.0);
        rotate(-90);
        hilbert0(n-1);
        forward(1.0);
        hilbert0(n-1);
        rotate(-90);
        forward(1.0);
        hilbert1(n-1);
        rotate(90);
    }

    public static void hilbert1(int n) {
        if (n == 0) return;
        rotate(-90);
        hilbert0(n-1);
        forward(1.0);
        rotate(90);
        hilbert1(n-1);
        forward(1.0);
        hilbert1(n-1);
        rotate(90);
        forward(1.0);
        hilbert0(n-1);
        rotate(-90);
    }
    
    public static void main(String args[]) {
        int N = 1;
        double max = Math.pow(2, N);
        Assignment3.setXscale(0, max);
        Assignment3.setYscale(0, max);
        x = 0.5;
        y = 0.5;
        hilbert0(N);
   }
}