import java.io.*;
import java.util.*;

public class BipartiteTest{
    
    static int v = 5;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
    private static Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
    private static int[] col = new int[6];
    
    private static boolean isBipartite(int node, int color){
        
        visited.put(node, 1);
        col[node] = color;
        //System.out.println("Color of " + node + " is " + color);
        for(Integer child : adj.get(node)){
            
            if(visited.get(child) == 0){
                if(isBipartite(child, color ^ 1) == false){
                    return false;
                } 
            }
            
            else if(col[node] == col[child]){
                return false;
            }
        }
        
        return true;
    }
    
    private static void addEdge(int s, int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
        visited.put(s,0);
        visited.put(d,0);
    } 
    
    public static void main(String args[]){
        
        for(int i = 0; i<v+1; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        addEdge(1,2);
        addEdge(2,3);
        addEdge(2,4);
        addEdge(3,4);
        addEdge(4,5);
        
        boolean status = isBipartite(1,0);
        System.out.println("Bipartite condition for given graph is : " + status);
    }
}


// Bipartite condition for given graph is : false
