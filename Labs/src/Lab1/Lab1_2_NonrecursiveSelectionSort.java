package Lab1;

public class Lab1_2_NonrecursiveSelectionSort {	
    public static int[] doSelectionSort(int[] nrss){        
        for (int i = 0; i < nrss.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < nrss.length; j++)
                if (nrss[j] < nrss[index])
                    index = j;
            int d1 = nrss[index]; 
            nrss[index] = nrss[i];
            nrss[i] = d1;
        }
        return nrss;
    }
 
    public static void main(String a[]){  
        int[] nrss1 = {9,11,15,7};
        int[] nrss2 = doSelectionSort(nrss1);
        for(int i:nrss2){
            System.out.print(i);
            System.out.print(" , ");
        }
    }
}