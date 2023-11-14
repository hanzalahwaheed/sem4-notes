public class InsertionSort {
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

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
}

    public static void arrPrint(int arr[]){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+"\t");
    }
    public static void main(String[] args) {
        int[] arr = randomTester(1000, 1, 3, 6);

        long startTime = System.nanoTime();
        insertionSort(arr);
        long time_taken = System.nanoTime() - startTime;

        arrPrint(arr);

        System.out.println("InsertionSort - Time taken: "+ time_taken +" ns | Length - "+arr.length);
    }
}