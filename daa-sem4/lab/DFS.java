import java.util.LinkedList;

public class DFS {
    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer>[] adj; // Adjacency list

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void depthFirstSearch(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start + " ");

            for (Integer neighbor : adj[start]) {
                if (!visited[neighbor]) {
                    depthFirstSearch(neighbor, visited);
                }
            }
        }

        void dfs(int start) {
            boolean[] visited = new boolean[V];
            System.out.print("Depth-First Traversal (starting from vertex " + start + "): ");
            depthFirstSearch(start, visited);
        }
    }

    public static void main(String[] args) {
        int vertices = 7; // Change this to the number of vertices in your graph
        Graph graph = new Graph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        int startVertex = 0; // Change this to the starting vertex for DFS
        graph.dfs(startVertex);
    }
}
