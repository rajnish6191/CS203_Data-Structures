package Assignment2;

public class GenericBinarySearch {
	public static void main(String[] args)
	{
		try
		{
			Integer[] a = {1,2,3,4,5};
			int location = binarySearch (a,4);
			System.out.println (location);
		}
	
		catch (Exception e)
		{
			System.out.println ("Error");
		}
	}
	public static <E extends Comparable<E>>int binarySearch(E[] list, E key){
	        int low = 0;
	        int high=list.length;
	        while (low <= high) {
	        	int mid=(low+high)/2;
				if(list[mid].compareTo(key)==0) return mid;
				else if(list[mid].compareTo(key)>0) high=mid-1;
				else low=mid+1;
	        }
	        return -1;
	    }
}