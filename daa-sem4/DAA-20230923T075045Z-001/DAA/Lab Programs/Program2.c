// Program 2: Write and execute a program to sort a given set of elements using the Merge sort method.

#include <stdio.h>

// Merge Function
void merge(int a[100], int low, int mid, int high)
{
    int b[100], i, j, k;
    i = low;
    j = mid + 1;
    k = low;
    while (i <= mid && j <= high)
    {
        if (a[i] < a[j])
        {
            b[k] = a[i];
            k += 1;
            i += 1;
        }
        else
        {
            b[k] = a[j];
            k += 1;
            j += 1;
            ;
        }
    }
    while (i <= mid)
    {
        b[k] = a[i];
        k += 1;
        i += 1;
    }
    while (j <= high)
    {
        b[k] = a[j];
        j += 1;
        k += 1;
    }
    for (i = low; i <= high; i++)
        a[i] = b[i];
}

// Mergesort Function
void mergesort(int a[100], int low, int high)
{
    int mid;
    if (low < high)
    {
        mid = (low + high) / 2;
        mergesort(a, low, mid);
        mergesort(a, mid + 1, high);
        merge(a, low, mid, high);
    }
}

// Main Program
int main()
{
    int n, a[100], i;
    printf("Enter the number of elements:\n");
    scanf("%d", &n);
    printf("Enter the %d elements:\n", n);
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);
    mergesort(a, 0, n - 1);
    printf("The sorted elements are:\n");
    for (i = 0; i < n; i++)
        printf("%d\t", a[i]);
}