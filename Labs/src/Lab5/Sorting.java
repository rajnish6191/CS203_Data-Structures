package Lab5;

public class Sorting {
		public static void main(String[] args)
		{
			try
			{
				Integer[] a = {8, 5, 1, 6};
				String[] name={"Rajnish","Anant","America"};
				Double[] d={0.5,0.9,0.1};
				insertionSort(a);
				insertionSort(name);
				insertionSort(d);
				
			}
			catch (IllegalArgumentException e)
			{
				System.out.println (e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println ("Something Went Wrong");
			}
		}
		
		public static <E extends Comparable<E>> void insertionSort(E[] list) {
		    int k, j;
		    E tmp;
		    int N = list.length;
		      
		    for (k = 1; k < N; k++)
		    {
		        tmp = list[k];
		        j = k - 1;
		        while ((j >= 0) && (list[j].compareTo(tmp) > 0))
		        {
		            list[j+1] = list[j]; 
		            j--;
		        }
		        list[j+1] = tmp;     
		                           
		    }
		    for (int i=0;i<list.length;i++)
		    {
		    	System.out.println(list[i]);
		    }
		}
}