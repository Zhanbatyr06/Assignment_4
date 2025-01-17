public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        // Create graph and add vertices
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        // Add edges between vertices
        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexA, vertexC, 3);
        graph.addEdge(vertexB, vertexD, 1);
        graph.addEdge(vertexC, vertexD, 1);
        graph.addEdge(vertexD, vertexE, 5);

        // Perform BFS
        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.search(vertexA);

        // Perform Dijkstra's algorithm
        System.out.println("\nDijkstra:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.search(vertexA);
    }
}
