import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;  // Set of vertices in the graph

    public WeightedGraph() {
        this.vertices = new HashSet<>();  // Initialize the set of vertices
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);  // Add a vertex to the graph
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;  // Return the set of vertices
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);  // Add edge from source to destination
        destination.addAdjacentVertex(source, weight);  // For undirected graph, add edge back
    }
}
