import java.util.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes(N):  ");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges(M):  ");
        int m = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0; i < n+1; i++){
            arr.add(new ArrayList<Integer>()); 
        }
        
        int a,b;
        while(m > 0){
            System.out.println("Enter the number of edges (a & b) ");
            a = sc.nextInt();
            b = sc.nextInt();
            addEdge(arr, a, b);
            m--;
        }
      
        printGraph(arr);
    }
    
    private static void addEdge(ArrayList<ArrayList<Integer>> arr, int a, int b){
        arr.get(a).add(b);
        arr.get(b).add(a); // for undirected graphs
    }
    
    private static void printGraph(ArrayList<ArrayList<Integer>> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.print(i + " ");
            for(int j = 0; j < arr.get(i).size(); j++){
               System.out.print("-> " + arr.get(i).get(j)); 
            }
            System.out.println();
        }
    }
}
