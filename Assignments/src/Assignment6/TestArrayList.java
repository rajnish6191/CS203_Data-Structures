package Assignment6;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
	public static void main(String[] args) 
	{
		 MyArrayList<String> list = new MyArrayList<String>();
		 list.add("America");
		 list.add("Russia");
		 list.add("Japan");
		 System.out.println(list);
		 
		 list.add(2,"Thailand");
		 System.out.println(list);
		 
		 list.clear();
		 System.out.println(list.size());
		 
		 list.add("America");
		 list.add("Russia");
		 list.add("Japan");
		 list.add("Mexico");
		 list.add("Nepal");
		 boolean k=list.contains("London");
		 System.out.println(k);
		 
		 String s1=list.get(1);
		 System.out.println(s1);
		 
		 int i=list.indexOf("Russia");
		 System.out.println("Index of Element Requested is:"+i);
		 
		 boolean k1=list.isEmpty();
		 System.out.println(k1);
		 
		 list.remove("Russia");
		 System.out.println(list);
		 
		 int sizeOfArrayList=list.size();
		 System.out.println("Size of ArrayList is:"+sizeOfArrayList);
		 
		 list.addFirst("Mongolia");
		 System.out.println(list);
		 
		 list.removeFirst();//Remove First
		 System.out.println("list after removing firts element"+list);

		 list.remove(2);
		 System.out.println("removing elements"+list);
		 
		 list.set(1,"Scotland");
		 System.out.println("After setting list:"+list);
		 
		 int sl=list.lastIndexOf("Scotland");
		 System.out.println(sl);
		 
		 Iterator<String> iterator = list.iterator();
		  while (iterator.hasNext()) 
		  {
			  System.out.print(iterator.next().toUpperCase() + " ");
		  }
		  System.out.println();
		  

		 MyLinkedList<String> list1 = new MyLinkedList<String>();
		 list1.add("Africa");
		 list1.add("Zimbabwe");
		 list1.add("New zealand");
		 System.out.println(list1);
		 
		 list1.add(1,"India");
		 System.out.println(list1);
		 
		 list1.clear();
		 System.out.println(list1.size());
		 
		 list1.add("Africa");
		 list1.add("Zimbabwe");
		 list1.add("New zealand");
		 list1.add("India");
		 
		 boolean k3=list1.contains("Japan");
		 System.out.println(k3);
		 
		 String s2=list1.get(2);
		 System.out.println(s2);
		 
		 int j=list1.indexOf("Africa");
		 System.out.println("Index of Element Requested is:"+j);

		 boolean k4=list1.isEmpty();
		 System.out.println(k4);
 		 
		 list1.remove("Zimbabwe");
		 System.out.println(list1);
		 
		 int sizeOfLinkedList=list1.size();
		 System.out.println("size of linked list is"+sizeOfLinkedList);

		 list1.remove(2);
		 System.out.println(list1);
		 
		 list1.addFirst("Dubai");
		 System.out.println(list1);

		 list1.removeFirst();
		 System.out.println(list1);
		 		 		 
		 list1.set(1,"pakistan");
		 System.out.println(list1);
		 
		 int f1=list1.lastIndexOf("pakistan");
		 System.out.println("Last index for requested:"+f1);
		 
		 Iterator<String> iterate = list1.iterator();
		  while (iterate.hasNext()) 
		  {
			  System.out.print(iterate.next().toUpperCase() + " ");
		  }
		  System.out.println();
	}
}