import java.util.*;

class MergeSort {
  public static int[] randomTester(
    int max,
    int min,
    int min_count,
    int max_count
  ) {
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

  public static void mergeSort(int[] arr, int l, int r) {
    if (l >= r) return;
    int mid = (l + r) / 2 ;
    mergeSort(arr, l, mid);  
    mergeSort(arr, mid + 1, r); 
    merge(arr, l, mid, r);
}
  private static void merge(int[] arr, int l, int mid, int r) {
    ArrayList<Integer> temp = new ArrayList<>(); 
    int i = l;      
    int j = mid + 1;   

    while (i <= mid && j <= r) {
        if (arr[i] <= arr[j]) {
            temp.add(arr[i]);
            i++;
        } else {
            temp.add(arr[j]);
            j++;
        }
    }

    while (i <= mid) {
        temp.add(arr[i]);
        i++;
    }

    while (j <= r) {
        temp.add(arr[j]);
        j++;
    }

    int z=l;
    for(Integer n:temp){
        arr[z] = n;
        z++;
    }
}

  public static void arrPrint(int arr[]) {
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + "\t");
  }

  public static void main(String[] args) {
    int[] arr = randomTester(1000, 1, 10, 100);

    long startTime = System.nanoTime();
    mergeSort(arr, 0, arr.length - 1);
    long time_taken = System.nanoTime() - startTime;

    // arrPrint(arr);

    System.out.println(
      "MergeSort - Time taken: " + time_taken + " ns | Length - " + arr.length
    );
  }
}
