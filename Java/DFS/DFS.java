import java.io.*;
import java.util.*;


public class DFS {
    static int n = 6;
    static int m = 6;
    
    private static Map<Integer, Integer> visited =  new HashMap<>();
    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      System.out.println("No.of Vertices (N): " + n);
      System.out.println("No.of Edges (M): " + m);
      for(int i = 0; i < n+1; i++)
        adjList.add(new ArrayList<Integer>());
      
      while (m > 0){
          System.out.println("Enter vertices a & b: ");
          int a = sc.nextInt();
          int b = sc.nextInt();
          addEdge(adjList, a, b, visited);
          m--;
      }
      
      printGraph(adjList);
      System.out.println("Start Node: " + adjList.get(1).get(0));
      findDFS(adjList.get(1).get(0));
      System.out.println("After: ");
      printDFS();
    }
    
    private static void findDFS(int v){
        visited.put(v, 1);
        System.out.println("Node " + v + " visited");
        for(Integer child : adjList.get(v)){
            if(visited.get(child) == 0){
                findDFS(child);
            }
        }
        
    }
    
    private static void printDFS(){
        System.out.print(visited.toString());
    }
    
    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int s, int d, Map<Integer, Integer> visited){
        adjList.get(s).add(d);
        adjList.get(d).add(s);
        visited.put(s,0);
        visited.put(d,0);
    }
    
    private static void printGraph(ArrayList<ArrayList<Integer>> adjList){
        for(int i = 0; i < adjList.size(); i++){
            System.out.print(i);
            for(int j = 0; j < adjList.get(i).size(); j++){
                System.out.print( " -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
    
}
