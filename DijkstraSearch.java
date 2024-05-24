import java.util.*;

public class DijkstraSearch<V> implements Search<V> {

    @Override
    public void search(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();  // Map to store the shortest distances to each vertex
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();  // Map to store the previous vertex in the shortest path
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));  // Priority queue for Dijkstra's algorithm

        // Initialize distances map with all vertices
        for (Vertex<V> vertex : getAllVertices(start)) {
            distances.put(vertex, Double.MAX_VALUE);  // Set initial distance to infinity for all vertices
        }
        distances.put(start, 0.0);  // Set the distance to the start vertex to 0
        priorityQueue.add(start);  // Add the start vertex to the priority queue

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();  // Extract the vertex with the smallest distance

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double distanceThroughCurrent = distances.get(current) + weight;  // Calculate the distance through the current vertex

                if (distanceThroughCurrent < distances.get(neighbor)) {
                    priorityQueue.remove(neighbor);  // Remove the neighbor from the priority queue
                    distances.put(neighbor, distanceThroughCurrent);  // Update the shortest distance to the neighbor
                    previous.put(neighbor, current);  // Update the previous vertex in the shortest path
                    priorityQueue.add(neighbor);  // Re-add the neighbor with the updated distance
                }
            }
        }

        // Print the shortest distances from the start vertex to all other vertices
        for (Map.Entry<Vertex<V>, Double> entry : distances.entrySet()) {
            System.out.println("Distance from " + start.getData() + " to " + entry.getKey().getData() + " is " + entry.getValue());
        }
    }

    // Helper method to get all vertices reachable from the start vertex
    private Set<Vertex<V>> getAllVertices(Vertex<V> start) {
        Set<Vertex<V>> allVertices = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        allVertices.add(start);  // Add the start vertex to the set of all vertices
        queue.add(start);  // Add the start vertex to the queue

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Dequeue a vertex

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!allVertices.contains(neighbor)) {
                    allVertices.add(neighbor);  // Add the neighbor to the set of all vertices
                    queue.add(neighbor);  // Enqueue the neighbor
                }
            }
        }
        return allVertices;  // Return the set of all vertices
    }
}
