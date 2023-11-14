import java.util.*;

class MergeSort{

    public static int [] randomTester(int max, int min, int min_count, int max_count){ 
        int len = (int)(Math.random() * max_count) + min_count; 
        int [] arr = new int[len];
        int i=0;
        while(i<len){
            int value=(int)(Math.random() * max) + min;
            arr[i]=value;
            i++;
        }
        return arr; 
    }

    public static void merge(int arr[], int start, int end, int r){
        int n1 = end - start + 1;
        int n2 = r - end;

        int [] L = new int[n1];
        int [] M = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[start + i];

        for (int i = 0; i < n2; i++)
            M[i] = arr[end + 1 + i];

        int i=0;
        int j=0;
        int k=start;

        while(i<n1 && j<n2){
            if(L[i]<=M[j])
                arr[k++]=L[i++];
            else
                arr[k++]=M[j++];
        }

        while(i<n1)
            arr[k++]=L[i++];

        while(j<n2)
            arr[k++]=L[j++];

    }

    public static void mergeSort(int arr[], int start, int r){
        if (start < r) {
            int end = start + (r - start) / 2;
    
            mergeSort(arr, start, end);
            mergeSort(arr, end + 1, r);
    
            merge(arr, start, end, r);
        }
    }

    public static void arrPrint(int arr[]){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+"\t");
    }
    public static void main(String[] args) {
        int[] arr = randomTester(1000, 1, 10, 100);

        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length -1);
        long time_taken = System.nanoTime() - startTime;

        // arrPrint(arr);

        System.out.println("MergeSort - Time taken: "+ time_taken +" ns | Length - "+arr.length);
    }
}