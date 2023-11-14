// Program 1: Write and execute a program to sort a given set of elements using the Quick sort method.

#include<stdio.h>

// Partition Function
int partition(int a[100], int low, int high) {
    int key, i, j, temp;
    key = a[low];
    i = low + 1;
    j = high;
    while(1) {
        while (key >= a[i])
            i++;
        while (key < a[j])
            j--;
        if(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        else {
            temp = a[j];
            a[j] = a[low];
            a[low] = temp;
            return j;
        }
    }
}

// Quicksort Function
void quicksort(int a[100], int low, int high) {
    int j;
    if(low < high) {
        j = partition(a, low, high);
        quicksort(a, low, j - 1);
        quicksort(a, j + 1, high);
    }
}

// Main Program
int main() {
    int n, a[100], i;
    printf("Enter the number of elements:\n");
    scanf("%d",&n);
    printf("Enter the %d elements:\n", n);
    for(i = 0; i < n; i++)
        scanf("%d",&a[i]);
    quicksort(a, 0, n - 1);
    printf("The sorted elements are:\n");
    for(i = 0; i < n; i++)
        printf("%d\t",a[i]);
}