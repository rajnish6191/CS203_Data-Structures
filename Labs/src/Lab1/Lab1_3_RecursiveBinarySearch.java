package Lab1;

public class Lab1_3_RecursiveBinarySearch {
	public static int rbs(int[] sortedArray, int start, int end, int key) {
	if (start < end) {
	int mid = start + (end - start) / 2;

	if (key < sortedArray[mid]) {
	return rbs(sortedArray, start, mid, key);
	} else if (key > sortedArray[mid]) {
	return rbs(sortedArray, mid+1, end , key);
	} else {
	return mid;
	}
	}
	return (start + 1);
	}
	
	public static void main(String[] args) {
	int[] arr1 = {12,68,42,92};
	int index = rbs(arr1,0,arr1.length,12);
	System.out.println("12 is at index: "+index+" ");
	index = rbs(arr1,0,arr1.length,68);
	System.out.println("68 is at index: "+index+" ");
	index = rbs(arr1,0,arr1.length,42);
	System.out.println("42 is at index: "+index+" ");
	index = rbs(arr1,0,arr1.length,92);
	System.out.println("92 is at index: "+index+" ");
		}
	}