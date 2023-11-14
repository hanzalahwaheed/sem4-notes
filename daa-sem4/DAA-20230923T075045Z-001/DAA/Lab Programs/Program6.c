// Program 6: Write and execute a program for matrix chain multiplication for the given the sequence of
// Matrices <A1, A2. . . . . An>

#include <stdio.h>
#include <limits.h>

// Matrix Chain Order Function
int mcm(int p[], int i, int j)
{
    int k, count;
    int min = INT_MAX;
    if (i == j)
        return 0;
    for (k = i; k < j; k++)
    {
        count = mcm(p, i, k) + mcm(p, k + 1, j) + p[i - 1] * p[k] * p[j];
        if (count < min)
            min = count;
    }
    return min;
}

// Main Program
int main()
{
    int a[] = {30, 35, 15, 5, 10, 20, 25};
    int n = sizeof(a) / sizeof(a[10]);
    printf("Minimum number of multiplications is %d\n", mcm(a, 1, n - 1));
}