import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private V startVertexData;

    public BreadthFirstSearch(WeightedGraph<V> graph, V startVertexData) {
        super(graph, startVertexData);
        this.startVertexData = startVertexData;
    }

    @Override
    public void search() {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        Vertex<V> startVertex = graph.getOrCreateVertex(startVertexData);
        queue.offer(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            List<Vertex<V>> neighbors = new ArrayList<>(currentVertex.getAdjacentVertices().keySet());
            for (Vertex<V> neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    relax(currentVertex, neighbor);
                }
            }
        }
    }
}
