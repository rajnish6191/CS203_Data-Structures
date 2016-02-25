package Lab2;

import java.util.ArrayList;

public class Lab2_1_GenericStack<E> extends ArrayList
{
	
		  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

		  public int getSize() 
		  {
		    return list.size();
		  }

		  public E peek() 
		  {
		    return list.get(getSize() - 1);
		  }

		  public void push(E pu) 
		  {
		    list.add(pu);
		  }

		  public E pop()
		  {
		    E po = list.get(getSize() - 1);
		    list.remove(getSize() - 1);
		    return po;
		  }

		  public boolean isEmpty() 
		  {
		    return list.isEmpty();
		  }
		  
		  @Override
		  public String toString() 
		  {
			return "stack: " + list.toString();
		  }
		
		  public static void main(String args[])
		  {
			  Lab2_1_GenericStack<String> sp = new Lab2_1_GenericStack();
			  	sp.push("101");
				sp.push("102");
				sp.push("103");
				sp.push("104");
	
			  	while(!sp.isEmpty())
			  	{
			  		System.out.println(sp.pop()+ "");
			  	}
			  	System.out.println();
		  }
};