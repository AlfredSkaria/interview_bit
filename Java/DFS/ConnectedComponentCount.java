import java.io.*;
import java.util.*;

public class ConnectedComponentCount{
    
    private int v;
    private int e;
    private Map<Integer, HashSet<Integer>> adjMap;
    private static Map<Integer, Integer> visited;
    
    ConnectedComponentCount(int vertices){
        v = vertices;
        adjMap = new HashMap<Integer, HashSet<Integer>>(); 
        visited = new HashMap<Integer, Integer>();
    }
    
    private void addEdge(int s, int d){
        adjMap.putIfAbsent(s, new HashSet<Integer>());
        adjMap.putIfAbsent(d, new HashSet<Integer>());
        adjMap.get(s).add(d);
        adjMap.get(s).add(s);
        adjMap.get(d).add(s);
        adjMap.get(d).add(d);
        visited.put(s, 0);
        visited.put(d, 0);
    }
    
    private void findDFS(int vertex){
        visited.put(vertex,1);
        System.out.println("vertex " + vertex + " visited");
        for(Integer child : adjMap.get(vertex)){
            if(visited.get(child) == 0){
               findDFS(child);
            }
        }
    }
    
    private void printGraph(){
        for(HashSet<Integer> v : adjMap.values()){
            System.out.println(v.toString());
        }
    }
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices (V): ");
        int vertices = sc.nextInt();
        
        System.out.println("Enter the number of edges (E): ");
        int edges = sc.nextInt();
        
        int ccCount = 0;
        
        ConnectedComponentCount ccc = new ConnectedComponentCount(vertices);
        
        while (edges > 0){
            System.out.println("Enter the nodes s & d: ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            ccc.addEdge(s,d);
            edges-- ;
        }
        
        ccc.printGraph();
        
        for(Integer vertex : visited.keySet()){
            if(visited.get(vertex) == 0){
                ccc.findDFS(vertex);
                System.out.println("CC Found");
                ccCount++;
            }
        }
        
        System.out.println("Number of cc component: " + ccCount);
        
        
    }
}


//Output
// Enter the number of vertices (V): 
// 10
// Enter the number of edges (E): 
// 8
// Enter the nodes s & d: 
// 11
// 55
// Enter the nodes s & d: 
// 22
// 88
// Enter the nodes s & d: 
// 88
// 66
// Enter the nodes s & d: 
// 66
// 55
// Enter the nodes s & d: 
// 66
// 44
// Enter the nodes s & d: 
// 3
// 7
// Enter the nodes s & d: 
// 100
// -1
// Enter the nodes s & d: 
// 55
// 22
// [-1, 100]
// [66, 55, 88, 44]
// [3, 7]
// [-1, 100]
// [22, 55, 88]
// [66, 22, 55, 11]
// [3, 7]
// [66, 22, 88]
// [55, 11]
// [66, 44]
// vertex -1 visited
// vertex 100 visited
// CC Found
// vertex 66 visited
// vertex 55 visited
// vertex 22 visited
// vertex 88 visited
// vertex 11 visited
// vertex 44 visited
// CC Found
// vertex 3 visited
// vertex 7 visited
// CC Found
// Number of cc component: 3
