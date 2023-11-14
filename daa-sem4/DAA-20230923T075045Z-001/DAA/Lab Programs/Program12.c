// Program 9: Write and execute a program to find solution to n- queens problem

#include <stdio.h>
#include <math.h>

// Place Function
int place(int x[10], int k)
{
    int i;
    for (i = 1; i <= k - 1; i++)
    {
        if (x[k] == x[i])
            return 0;
        if (abs(x[k] - x[i]) == abs(i - k))
            return 0;
    }
    return 1;
}

// NQueen Function
void nqueen(int n)
{
    int x[10], k = 1, i, count = 0;
    x[k] = 0;
    while (k != 0)
    {
        x[k] = x[k] + 1;
        while (x[k] <= n && place(x, k) == 0)
            x[k] = x[k] + 1;
        if (x[k] <= n)
        {
            if (k == n)
            {
                count++;
                printf(" \nSolution %d is \n", count);
                for (i = 1; i <= n; i++)
                    printf("%d \t", x[i]);
            }
            else
            {
                k = k + 1;
                x[k] = 0;
            }
        }
        else
            k--;
    }
}

// Main Program
int main()
{
    int n;
    printf("Enter the number of queens:\n");
    scanf("%d", &n);
    if (n == 1 || n == 2 || n == 3)
        printf("Solution is not posible.\n");
    else
        nqueen(n);
}