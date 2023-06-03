import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private V startVertexData;

    public DijkstraSearch(WeightedGraph<V> graph, V startVertexData) {
        super(graph, startVertexData);
        this.startVertexData = startVertexData;
    }

    @Override
    public void search() {
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(vertex -> distTo.get(vertex)));
        Set<Vertex<V>> visited = new HashSet<>();

        Vertex<V> startVertex = graph.getOrCreateVertex(startVertexData);
        priorityQueue.offer(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();
            visited.add(currentVertex);

            for (Vertex<V> neighbor : currentVertex.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    relax(currentVertex, neighbor);
                    priorityQueue.offer(neighbor);
                }
            }
        }
    }
}
