import java.util.*;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected Map<Vertex<V>, Double> distTo;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;

    public Search(WeightedGraph<V> graph, V startVertexData) {
        this.graph = graph;
        this.distTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
        initializeDistances(startVertexData);
    }

    protected void initializeDistances(V startVertexData) {
        for (Vertex<V> vertex : graph.getVertices()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(graph.getOrCreateVertex(startVertexData), 0.0);
    }

    public abstract void search();

    public List<V> pathTo(V destinationData) {
        List<V> path = new ArrayList<>();
        Vertex<V> destinationVertex = graph.getOrCreateVertex(destinationData);

        if (!edgeTo.containsKey(destinationVertex)) {
            return path;
        }

        Vertex<V> currentVertex = destinationVertex;
        while (currentVertex != null) {
            path.add(0, currentVertex.getData());
            currentVertex = edgeTo.get(currentVertex);
        }
        return path;
    }

    protected void relax(Vertex<V> sourceVertex, Vertex<V> destinationVertex) {
        double weight = sourceVertex.getAdjacentVertices().get(destinationVertex);
        double newDistance = distTo.get(sourceVertex) + weight;

        if (newDistance < distTo.get(destinationVertex)) {
            distTo.put(destinationVertex, newDistance);
            edgeTo.put(destinationVertex, sourceVertex);
        }
    }
}
