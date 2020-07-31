import java.io.*;
import java.util.*;

public class SSSPTree{
    
    static int v = 6;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
    private static Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> sssp = new HashMap<Integer, Integer>();
    
    private static void addEdge(int s, int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
        visited.put(s,0);
        visited.put(d,0);
    }
    
    private static void dfs(int node, int dist){
        visited.put(node,1);
        sssp.put(node, dist);
        for(Integer v : adj.get(node)){
            if(visited.get(v) == 0){
                dfs(v, dist + 1);
            }
        }
    }
    
    
    
    public static void main(String args[]){
        
        for(int i = 0; i<7; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        addEdge(1,2);
        addEdge(2,3);
        addEdge(2,4);
        addEdge(4,5);
        addEdge(4,6);
        
        dfs(2,0);
        System.out.println("Distance from node 1 to other nodes: " + sssp.toString());
    }
}

//Output
//Distance from node 1 to other nodes: {1=1, 2=0, 3=1, 4=1, 5=2, 6=2}
