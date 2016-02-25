package Lab1;

import java.util.Scanner;

public class Lab1_1_Power2 
{
	public static void main(String s[])
	{
		Scanner pp = new Scanner(System.in);
		System.out.println("Please Put the Number(n): ");
		int num = pp.nextInt();
		int p1 = po(num);
		System.out.println("Your Answer(2^n) is: "+p1);
	}
		public static int po(int n)
	{
		if(n==0)
			return 1;
		else
			return po(n-1)*2;
	}
}