import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;  // Data held by the vertex
    private Map<Vertex<V>, Double> adjacentVertices;  // Adjacent vertices and edge weights

    public Vertex(V data) {
        this.data = data;  // Initialize vertex data
        this.adjacentVertices = new HashMap<>();  // Initialize the map of adjacent vertices
    }

    public V getData() {
        return data;  // Return the vertex data
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);  // Add an adjacent vertex and the edge weight
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;  // Return the map of adjacent vertices
    }
}
