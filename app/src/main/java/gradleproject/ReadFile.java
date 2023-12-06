package gradleproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.File;
import com.google.common.graph.*;
import java.awt.Color;



public class ReadFile {

  public static void ReadInFile() {
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
    MutableGraph<String> graph = GraphBuilder.directed().build();

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
      graph.putEdge(vertices[0], vertices[1]);
      // vertices[0].addNode();
    }

    new GraphDisplay(graph);

    scanner.close();
  }

  public static void DijkstraAlgorithm() {
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
     
  }

    public static void main(String[] args) {
      ReadFile.ReadInFile();
    }
}
