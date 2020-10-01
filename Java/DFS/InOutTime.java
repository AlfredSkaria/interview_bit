import java.io.*;
import java.util.*;


public class InOutTime{
    
    static int v = 5;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
    private static Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
    private static int[] inTime = new int[v+1];
    private static int[] outTime = new int[v+1];
    static int timer=1;
    
    private static void addEdge(int s, int d){
        adj.get(s).add(d);
        adj.get(d).add(s);
        visited.put(s,0);
        visited.put(d,0);
    }
    
    private static void findInOutTime(int node){
        visited.put(node,1);
        //System.out.println("Node: " + node + " visited");
        inTime[node] = timer++;
        for(Integer child : adj.get(node)){
            if(visited.get(child) == 0){
                findInOutTime(child);
            }
        }
        outTime[node] = timer++;
    }
    
    
    private static void printArray(int[] arr, String arrName){
        System.out.print(arrName+ " array: ");
        for(int i=1; i<v+1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
        
        findInOutTime(1);
        printArray(inTime, "InTime");
        printArray(outTime, "OutTime");
        
    }
}


// Output
// InTime array: 1 2 3 4 5 
// OutTime array: 10 9 8 7 6 
