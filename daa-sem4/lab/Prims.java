import java.util.Arrays;

public class Prims {
    static final int V = 5; // Number of vertices in the graph

    // Function to find the vertex with the minimum key value
    static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print the minimum spanning tree
    static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \t Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Function to find the minimum spanning tree using Prim's algorithm
    static void primMST(int[][] graph) {
        int[] parent = new int[V]; // Array to store the constructed MST
        int[] key = new int[V]; // Key values used to pick the minimum weight edge

        boolean[] mstSet = new boolean[V]; // To represent vertices included in MST

        // Initialize all keys to INFINITY and mstSet[] to false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Always include the first vertex in MST
        key[0] = 0; // Make the key 0 so that this vertex is picked as the first vertex
        parent[0] = -1; // First vertex is always the root of the MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST
            mstSet[u] = true;

            // Update key value and parent index of adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
