public class Main {
    public static void main(String[] args) {
        // Create the weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Create vertices
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");

        // Add vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        // Add edges with weights
        graph.addEdge(v1, v2, 2.0);
        graph.addEdge(v1, v3, 4.0);
        graph.addEdge(v2, v3, 1.0);
        graph.addEdge(v2, v4, 7.0);
        graph.addEdge(v3, v4, 3.0);
        graph.addEdge(v3, v5, 5.0);
        graph.addEdge(v4, v5, 2.0);

        // Perform BFS
        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        bfs.search(v1);

        // Reset vertices for Dijkstra's algorithm
        for (Vertex<String> vertex : graph.getVertices()) {
            vertex.setMinDistance(Double.POSITIVE_INFINITY);
            vertex.setPreviousVertex(null);
        }

        // Perform Dijkstra's algorithm
        System.out.println("\nDijkstra's Algorithm:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.search(v1);
    }
}
