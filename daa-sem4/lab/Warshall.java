public class Warshall {
    static void warshallPathExists(boolean[][] graph) {
        int V = graph.length;
        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // If there is a path from i to k and k to j, then there is a path from i to j
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        // Print whether there is a path between each pair of vertices
        System.out.println("Existence of paths between vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j]) {
                    System.out.print("1 "); // Path exists
                } else {
                    System.out.print("0 "); // No path exists
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        boolean[][] graph = new boolean[V][V];
        
        // Initialize the graph adjacency matrix (true if there is an edge)
        graph[0][1] = true;
        graph[1][2] = true;
        graph[2][3] = true;

        System.out.println("Initial adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((graph[i][j] ? "1 " : "0 "));
            }
            System.out.println();
        }

        warshallPathExists(graph);
    }
}
