// Program 3b: Write and execute a program to print all the nodes reachable from a given starting node
// in a graph using BFS method.

#include <stdio.h>

// BFS Function
void bfs(int n, int a[10][10], int source, int s[10])
{
    int q[10], f = 1, r = 1, i, u;
    printf("%d\t", source);
    s[source] = 1;
    q[r] = source;
    while (f <= r)
    {
        u = q[f];
        f = f + 1;
        for (i = 1; i <= n; i++)
        {
            if (s[i] == 0 && a[u][i] == 1)
            {
                r = r + 1;
                q[r] = i;
                s[i] = 1;
                printf("%d\t", i);
            }
        }
    }
}

// Main Program
int main()
{
    int n, a[10][10], source, s[10], i, j;
    printf("Enter the number of nodes:\n");
    scanf("%d", &n);
    printf("Enter the adjacency matrix:\n", n);
    for (i = 1; i <= n; i++)
        for (j = 1; j <= n; j++)
            scanf("%d", &a[i][j]);
    printf("Enter the source node:\n");
    scanf("%d", &source);
    for (i = 1; i <= n; i++)
        s[i] = 0;
    printf("The BFS order of the graph is:\n");
    bfs(n, a, source, s);
}