import java.util.*;
class Search{

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

    public static int linear(int [] arr, int key) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==key)
                return i;

        }
        return -1;
    }

    public static int binary(int [] arr, int key) {
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
                high=mid-1;
            else if(arr[mid]<key)
                low=mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = randomTester(1000, 1, 10, 100);

        Arrays.sort(arr);

        for(int i=0; i<5; i++){
            int index = (int)(Math.random() * arr.length);

            long startTime = System.nanoTime();
            int result = linear(arr, arr[index]);
            long time_taken = System.nanoTime() - startTime;
            System.out.println("Linear Search - Result: "+ result +" | Time taken: "+ time_taken +" ns");

            startTime = System.nanoTime();
            result = binary(arr, arr[index]);
            time_taken = System.nanoTime() - startTime;
            System.out.println("Binary Search - Result: "+ result +" | Time taken: "+ time_taken +" ns");
        }
    }
}