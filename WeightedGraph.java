import java.util.*;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = getOrCreateVertex(source);
        Vertex<V> destinationVertex = getOrCreateVertex(destination);
        sourceVertex.addAdjacentVertex(destinationVertex, weight);
        if (!directed) {
            destinationVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public Vertex<V> getOrCreateVertex(V data) {
        if (!vertices.containsKey(data)) {
            Vertex<V> vertex = new Vertex<>(data);
            vertices.put(data, vertex);
        }
        return vertices.get(data);
    }

    public boolean isDirected() {
        return directed;
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
