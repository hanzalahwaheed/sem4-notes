// Program 7: Write and execute a program to find a longest-common-subsequence of X and Y using dynamic
// programming for given two sequences X = <x1,x2. . . . . xm> Y = <y1 y2. . . . .yn>

#include <stdio.h>
#include <string.h>

// Max Function
int max(int a, int b)
{
    if (a > b)
        return a;
    else
        return b;
}

// LCS Function
void lcs(char x[100], char y[100], int m, int n)
{
    int len, i, j, l[100][100];
    char lc[100];
    for (i = 0; i <= m; i++)
    {
        for (j = 0; j <= n; j++)
        {
            if (i == 0 || j == 0)
                l[i][j] = 0;
            else
            {
                if (x[i - 1] == y[j - 1])
                    l[i][j] = l[i - 1][j - 1] + 1;
                else
                    l[i][j] = max(l[i - 1][j], l[i][j - 1]);
            }
        }
    }
    printf("LCS length is %d\n", l[m][n]);
    len = l[m][n];
    lc[len] = '\0';
    i = m;
    j = n;
    while (i > 0 && j > 0)
    {
        if (x[i - 1] == y[j - 1])
        {
            lc[len - 1] = x[i - 1];
            i--;
            j--;
            len--;
        }
        else
        {
            if (l[i - 1][j] > l[i][j - 1])
                i--;
            else
                j--;
        }
    }
    printf("The LCS is %s\n", lc);
}

// Main Pprogram
int main()
{
    char x[100], y[100];
    int m, n;
    printf("Enter the first string:\n");
    gets(x);
    printf("Enter the second string:\n");
    gets(y);
    m = strlen(x);
    n = strlen(y);
    lcs(x, y, m, n);
}