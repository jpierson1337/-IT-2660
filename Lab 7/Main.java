class Main {
  public static void main(String[] args) {
    String[] vertices = {
            "Liberal Arts",
            "Student Services",
            "Health Careers & Sciences",
            "Health Technologies Center",
            "Recreation Center",
            "Technology Learning Center",
            "Business & Technology",
            "Theatre"
    };

    int[][] edges = {
            {0,1}, // Liberal Arts - Student Services
            {1,2}, // Student Services - Health Careers & Sciences
            {2,3}, // Health Careers & Sciences - Health Technologies Center
            {2,4}, // Health Careers & Sciences - Recreation Center
            {4,5}, // Recreation Center - Technology Learning Center
            {5,6}, // Technology Learning Center - Business & Technology
            {6,7}  // Business & Technology - Theatre
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
                " is " + graph.getVertex(dfs.getParent(i)));

    // Print paths
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();

    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();

    dfs.printPath(graph.getIndex("Recreation Center"));
    System.out.println();

    // Print the entire tree
    dfs.printTree();
  }
}
