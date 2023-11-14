import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V, E; // Number of vertices and edges
        Edge[] edges; // Array to store all edges

        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[e];
        }
    }

    // Comparator to sort edges based on their weights
    static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge a, Edge b) {
            return a.weight - b.weight;
        }
    }

    // Function to find the parent of a vertex
    static int findParent(int[] parent, int vertex) {
        if (parent[vertex] == -1)
            return vertex;
        return findParent(parent, parent[vertex]);
    }

    // Function to perform union of two sets
    static void union(int[] parent, int x, int y) {
        int xParent = findParent(parent, x);
        int yParent = findParent(parent, y);
        parent[xParent] = yParent;
    }

    // Function to find the minimum spanning tree using Kruskal's algorithm
    static void kruskalMST(Graph graph) {
        Edge[] result = new Edge[graph.V - 1]; // Stores the edges of the MST
        int[] parent = new int[graph.V]; // Used to check for cycles

        Arrays.fill(parent, -1);

        // Sort all edges in increasing order of their weights
        Arrays.sort(graph.edges, new EdgeComparator());

        int i = 0; // Index of the result[] array
        int e = 0; // Index of the sorted edges[] array

        while (i < graph.V - 1 && e < graph.E) {
            Edge nextEdge = graph.edges[e++];
            int x = findParent(parent, nextEdge.src);
            int y = findParent(parent, nextEdge.dest);

            // If including this edge doesn't form a cycle, add it to the result[]
            if (x != y) {
                result[i++] = nextEdge;
                union(parent, x, y);
            }
        }

        // Print the edges of the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (i = 0; i < graph.V - 1; i++) {
            System.out.println(
                result[i].src + " - " + result[i].dest + " : " + result[i].weight
            );
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges
        Graph graph = new Graph(V, E);

        // Add edges to the graph
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        kruskalMST(graph);
    }
}
