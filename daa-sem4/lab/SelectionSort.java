public class SelectionSort {
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

    static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIdx])
                minIdx = j;
        }
        if (minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}

    public static void arrPrint(int arr[]){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+"\t");
    }
    public static void main(String[] args) {
        int[] arr = randomTester(1000, 1, 10, 100);

        long startTime = System.nanoTime();
        selectionSort(arr);
        long time_taken = System.nanoTime() - startTime;

        // arrPrint(arr);

        System.out.println("SelectionSort - Time taken: "+ time_taken +" ns | Length - "+arr.length);
    }
}