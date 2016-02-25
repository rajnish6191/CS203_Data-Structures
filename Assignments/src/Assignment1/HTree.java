package Assignment1;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Scanner;

public class HTree {
	 private static Graphics2D os;

	 public static void line(double x0, double y0, double x1, double y1) 
	 {
	        os.draw(new Line2D.Double(x0, y0,x1,y1));
	 }
	 
	 public static void drawH(double x, double y, double size) {
	        double x0 = x - size/2;
	        double x1 = x + size/2;
	        double y0 = y - size/2;
	        double y1 = y + size/2;
	        Assignment1.line(x0, y0, x0, y1);    
	        Assignment1.line(x1, y0, x1, y1);    
	        Assignment1.line(x0,  y, x1,  y);    
	    }
	 
	 public static void draw(int n, double x, double y, double size) {
	        if (n == 0) return;
	        drawH(x, y, size);
	        double x0 = x - size/2;
	        double x1 = x + size/2;
	        double y0 = y - size/2;
	        double y1 = y + size/2;
	        draw(n-1, x0, y0, size/2);
	        draw(n-1, x0, y1, size/2);
	        draw(n-1, x1, y0, size/2);
	        draw(n-1, x1, y1, size/2);
	    }
	 
	 public static void main(String[] args) {
	    	Scanner s1 = new Scanner(System.in);
	    	int N= s1.nextInt();
	        double x = 0.5, y = 0.5;  
	        double size = 0.5;  
	        draw(N, x, y, size);
	    }
	}