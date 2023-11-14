// Program 5: Write and execute a program to search for the given pattern string in given text string
// using Horspool String Matching algorithm.

#include <stdio.h>
#include <string.h>

// Horspool Function
int horspool(char T[100], char P[100], int n, int m)
{
    char ST[200];
    int i, j;
    for (i = 0; i < n; i++)
        ST[T[i]] = m;
    for (i = 0; i < m - 1; i++)
        ST[P[i]] = m - 1 - i;
    i = m - 1;
    while (i < n)
    {
        j = 0;
        while (j < m && (P[m - 1 - j] == T[i - j]))
            j = j + 1;
        if (j == m)
            return (i - m + 1);
        else
            i = i + ST[T[i]];
    }
    return -1;
}

// Main Function
int main()
{
    char T[100], P[100];
    int i, j, n, m, flag;
    printf("Enter the text string:\n");
    gets(T);
    printf("Enter the pattern string:\n");
    gets(P);

    n = strlen(T);
    m = strlen(P);

    flag = horspool(T, P, n, m);
    if (flag == -1)
        printf("String not found!\n");
    else
        printf("String found from index %d.", flag);
}
