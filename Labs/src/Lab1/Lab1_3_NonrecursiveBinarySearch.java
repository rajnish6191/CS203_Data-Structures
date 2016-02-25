package Lab1;

import java.util.*;

public class Lab1_3_NonrecursiveBinarySearch {
	   public static void main(String args[])
	   {
	      int count, num, item, a[], low, high, middle;
	      
	      Scanner input = new Scanner(System.in);
	      System.out.println("Please Type the Number for RBS Elements:");
	      num = input.nextInt(); 

	      a = new int[num];
	      System.out.println("Please Enter " + num + " integers: ");
	      
	      for (count = 0; count < num; count++)
	       a[count] = input.nextInt();

	      System.out.println("Which value you want to search:");
	      item = input.nextInt();
	      low = 0;
	      high = num - 1;
	      middle = (low + high)/2;

	      while( low <= high )
	      {
	         if ( a[middle] < item )
	         {
	           low = middle + 1;
	         }
	           
	         else if ( a[middle] == item )
	         {
	           System.out.println(item + " is at the level of: " + (middle + 1) + " ");
	           break;
	         }
	         else
	         {
	             high = middle - 1;
	         }
	         middle = (low + high)/2;
	      }
	      if ( low > high )
	          System.out.println(item + " Something went wrong / Not Present \n");
	   }
	}