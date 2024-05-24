import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {

    @Override
    public void search(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();  // Set to track visited vertices
        Queue<Vertex<V>> queue = new LinkedList<>();  // Queue for BFS

        visited.add(start);  // Mark the start vertex as visited
        queue.add(start);  // Enqueue the start vertex

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Dequeue a vertex
            System.out.println(current.getData());  // Process the vertex

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);  // Mark the neighbor as visited
                    queue.add(neighbor);  // Enqueue the neighbor
                }
            }
        }
    }
}
