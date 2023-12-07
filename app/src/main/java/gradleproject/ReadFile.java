package gradleproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.File;
import com.google.common.graph.*;
import java.awt.Color;



public class ReadFile {

  public static HashSet<String> ReadInFile(MutableValueGraph<String,Integer> graph, HashSet<String> listOfVertices) {
    String filename = "app\\src\\main\\java\\gradleproject\\TexasRoadnetworks.txt";
    File file = null;

    Scanner scanner = null;
      
    try {
      file = new File(filename);
    }
    // find exactly what exception this is supposed to be
    catch (Exception e) {
      System.out.println("Cannot locate file.");
      System.exit(-1);
    }

    try {
      scanner = new Scanner(file);
    }
    catch (Exception e){
      System.out.println("scanner not working");
      e.printStackTrace();
      System.exit(-1);
    }
    

    //Need to initialize nodes in text files
    // Node fromNodeID = new ReadFile(File[0]);
    // Node ToNodeID = File[1];

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] vertices = line.split("\t");
      // ArrayList<String> verticesList = new ArrayList<String>(Arrays.asList(vertices));
      // System.out.println(verticesList.toString());

      System.out.println("1st node: " + vertices[0] + " 2nd node: " + vertices[1]);

      graph.addNode(vertices[0]);
      graph.putEdgeValue(vertices[0], vertices[1], 1);
      
      
      if (!listOfVertices.contains(vertices[0])) {
        listOfVertices.add(vertices[0]);
      }
      // vertices[0].addNode();
    }

    new GraphDisplay(graph);

    scanner.close();
    return listOfVertices;
  }

  public static void DijkstraAlgorithm(MutableGraph<String> graph, HashSet<String> listOfVertices, String source) {
    //psuedocode from Wikipedia page:
    //  1  function Dijkstra(Graph, source):
    //  2 
    //  3      for each vertex v in Graph.Vertices:
    //  4          dist[v] ← INFINITY
    //  5          prev[v] ← UNDEFINED
    //  6          add v to Q
    //  7      dist[source] ← 0
    //  8      
    //  9      while Q is not empty:
    // 10          u ← vertex in Q with min dist[u]
    // 11          remove u from Q
    // 12          
    // 13          for each neighbor v of u still in Q:
    // 14              alt ← dist[u] + Graph.Edges(u, v)
    // 15              if alt < dist[v]:
    // 16                  dist[v] ← alt
    // 17                  prev[v] ← u
    // 18
    // 19      return dist[], prev[]
     String startNode = "0";

     int[] distance = new int[listOfVertices.size()];
     boolean[] visited = new boolean[listOfVertices.size()];
     String[] via = new String[listOfVertices.size()];
     String[] prev = new String[listOfVertices.size()];
     String[] Q = new String[listOfVertices.size()];

     for (int v = 0; v < listOfVertices.size(); v++) {
        distance[v] = 9999;
        prev[v] = "undefined";
        Q[v] = listOfVertices.toArray()[v].toString();
      }

      distance[Arrays.asList(Q).indexOf(source)] = 0;

      while (Q != null && Q.length > 0) {
    // 10          u ← vertex in Q with min dist[u]
    // 11          remove u from Q
        // Node u = Q
        // Q[v] = ;
      }
    // 13          for each neighbor v of u still in Q:
    // 14              alt ← dist[u] + Graph.Edges(u, v)
    // 15              if alt < dist[v]:
    // 16                  dist[v] ← alt
    // 17                  prev[v] ← u
    // 18
    // 19      return dist[], prev[]

  }

    public static void main(String[] args) {
      //MutableGraph<String> graph = GraphBuilder.directed().build();
      MutableValueGraph<String,Integer> graph = ValueGraphBuilder.undirected().build();
      HashSet<String> listOfVertices = new HashSet<>();
      listOfVertices = ReadFile.ReadInFile(graph, listOfVertices);

      
    }
}
