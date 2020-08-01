import java.io.*;
import java.util.*;

public class CycleDetection{
    
    static int v = 5;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
    private static int[] visited = new int[6];
    
    private static void addEdge(int s, int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
    }
    
    private static boolean detectCycle(int node, int par){
        
        visited[node] = 1;
        
        for(Integer child : adj.get(node)){
            
            if(visited[child] == 0){
                
                if(detectCycle(child, node) == true){
                    return true;
                }
            }
            
            else if(child != par){
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String args[]){
        
        for(int i = 0; i < v+1; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        addEdge(1,2);
        addEdge(2,3);
        addEdge(2,4);
        addEdge(3,4);
        addEdge(4,5);
        
        boolean status = detectCycle(1,1);
        
        System.out.println("Cycle presence in graph: " + status);
        
    }
}

// Output
// Cycle presence in graph: true
