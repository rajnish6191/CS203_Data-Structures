package Lab4;
import java.util.*;

public class Algorithms 
{
	    private static Scanner sc;

		public static void main(String[]args)throws Exception
	    {
	         
	        sc = new Scanner(System.in);
	        ArrayList<Integer> num = new ArrayList<Integer>();
	        
	        Scanner in=new Scanner(System.in);
	        System.out.println("Enter any number");
	        int n=in.nextInt();
	        int[] num1 = new int[n];
	        System.out.print("enter numbers: ");

	        for(n = 0;n<num1.length; n++)
	        {
	            System.out.print(" ");
	            num1[n] = sc.nextInt();
	            if (num1[n]== 0)
	            {
	                break;
	            } 
	            num.add(num1[n]);                  
	        }
	        Collections.sort(num);
	        System.out.println("<KEY\tValues>");
	        int p=0;
	        while (p<num.size())
	        {
	            int number = num.get(p);
	                int counter = 0;
	                while(p<num.size() && num.get(p)==number)
	                 {
	                       counter++;
	                       p++;
	                 }
	                 
	                 System.out.println(+number+"\t"+counter);
	                                 
	        }
	        
	    }
	}