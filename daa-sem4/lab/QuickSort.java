public class QuickSort {
    public static int[] randomTester(int max, int min, int min_count, int max_count) {
        int len = (int) (Math.random() * max_count) + min_count;
        int[] arr = new int[len];
        int i = 0;
        while (i < len) {
            int value = (int) (Math.random() * max) + min;
            arr[i] = value;
            i++;
        }
        return arr;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void arrPrint(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
    }

    public static void main(String[] args) {
        int[] arr = randomTester(1000, 1, 3, 6);

        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long time_taken = System.nanoTime() - startTime;

        arrPrint(arr);

        System.out.println("QuickSort - Time taken: " + time_taken + " ns | Length - " + arr.length);
    }
}