package Lab2;

public class Lab2_2_GMFLinearSearch {
		public static void main(String[] args)
		{
			try
			{
				Integer[] a = {8, 5, 1, 5};
				int location = linearSearch (a, 1);
				System.out.println (location);
			}
			catch (IllegalArgumentException e)
			{
				System.out.println (e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println ("Unexpected Termination");
			}
		}
		public static <E extends Comparable<E>> int linearSearch (E[] list, E key)
		{
			if (list == null)
				throw new IllegalArgumentException ("null array argument");
			int i = 0;
			while (i < list.length && key.compareTo(list[i]) != 0)
				i++;
			if (i == list.length)
				i = -1;
			return i;
		}
	}