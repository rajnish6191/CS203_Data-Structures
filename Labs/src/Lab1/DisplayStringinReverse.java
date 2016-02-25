package Lab1;

import java.util.*;

public class DisplayStringinReverse
{
   public static void main(String args[])
   {
      String original, reverse = "";
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter the String: ");
      original = in.nextLine();
 
      int length = original.length();
 
      for ( int i = length - 1 ; i >= 0 ; i-- )
         reverse = reverse + original.charAt(i);
 
      System.out.println("Reversed String: "+reverse);
   }
}