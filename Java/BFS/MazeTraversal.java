import java.io.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


class Node{
    int x,y,dist;
}



public class MazeTraversal{
                    // D  U R L
    static int[] x1 = {1,-1,0, 0};
    static int[] y1 = {0, 0,1,-1};

    void displayMaze(boolean[][] maze){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("\n");
        }
    }


    boolean isValid(int p, int q, int dist, boolean[][] booleanMaze, int[][] maze){
        
        if(p >= 0 && q >= 0 && dist >=0 && p <= 3 && q <= 4){
            if(maze[p][q] != 0 && booleanMaze[p][q]){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    Node shortestPath(int[][] maze, int s1, int s2, int d1, int d2){
        boolean[][] booleanMaze  = new boolean[4][5];
        for(boolean[] row : booleanMaze){
            Arrays.fill(row, true);
        }

        //displayMaze(booleanMaze);
            Node node = new Node();
            int p,q,dist;
            node.x = s1;
            node.y = s2;
            node.dist = 0;
            Queue<Node> que = new LinkedList<>();
            que.add(node);
            booleanMaze[3][4] = false;
                
                while(!que.isEmpty()){

                    Node point = que.peek();
                    Node dest = new Node();
                    for(int i=0 ; i < 4 ; i++){
                        p = point.x + x1[i];
                        q = point.y + y1[i];
                        dist = point.dist;
                        System.out.println("####");
                        //System.out.print(booleanMaze[point][q]);
                        System.out.println("***  (" + p + "," + q +")"+ " dist:" + dist);
                        if(isValid(p, q, dist, booleanMaze, maze)){
                            //System.out.println("$$");
                            
                            dest.x = p;
                            dest.y = q;
                            dest.dist = point.dist + 1;
                            que.add(dest);
                            
                            System.out.println(" $$ (" + dest.x + "," + dest.y +")"+ " dist:" + dest.dist);
                            
                        }
                        if(p == d1 && q==d2){
                            return dest;
                        }
                        if(p >= 0 && q >=0 && p <= 3 && q <= 4){
                            booleanMaze[p][q] = false;
                        }

                    }
                    que.remove();
                }

        return null;
    }

    public static void main(String args[]){
        int[][] maze = {{1,1,0,1,1},
                        {0,1,0,1,1},
                        {0,1,1,1,0},
                        {1,0,1,1,1}};

        MazeTraversal m1 = new MazeTraversal();
        Node destinationNode = m1.shortestPath(maze,3,4,1,4);
        if(destinationNode !=  null){
            System.out.println("Shortest Path : " + destinationNode.dist);
        }else{
            System.out.println("No Shortest path found");
        }
    }
}