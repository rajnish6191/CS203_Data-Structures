package Lab1;

public class Lab1_1_PowerX {
		public double power(double x, int n)
			{
			 if (n <= 0)
			return 1;
			 else
			return x * power(x, n-1);
			}
			
		 public static void main(String[] args)
		 {
			 Lab1_1_PowerX px=new Lab1_1_PowerX();
			 System.out.println("The Answer(X^n) is: "+px.power(7, 8));
		  }  
	}