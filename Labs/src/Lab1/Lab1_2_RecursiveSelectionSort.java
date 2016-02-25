package Lab1;

public class Lab1_2_RecursiveSelectionSort {
        public static void main(String [] args){
           double[] sortingList = {7,9,4,5};    
           sort(sortingList);
               for (int i=0; i<sortingList.length; i++)
           {
                  System.out.println("Recursive Sorted List is: " +sortingList[i]);
           }
    }

public static void sort(double[] list) {
           sort(list, 0, list.length - 1); 
    }

public static void sort(double[] list, int low, int high) {
           if (low < high) {
                  int indexOfMin = low;
                  double min = list[low];
                  for (int i = low + 1; i <= high; i++) {
                        if (list[i] < min) {
                               min = list[i];
                               indexOfMin = i;
                        }
                  }
                  list[indexOfMin] = list[low];
                  list[low] = min;
                  sort(list, low + 1, high);
           }
    }
}