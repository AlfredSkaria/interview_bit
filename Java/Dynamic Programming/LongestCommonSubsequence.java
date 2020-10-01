import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        int s1Length = s1.length();
        int i = 0, j = 0;
        int[][] cc = new int[s1Length + 1][s1Length + 1];

        for(i = 0; i <= s1Length; i++){
           cc[i][0] = 0; 
        }
        
        for(i = 0; i <= s1Length; i++){
           cc[0][i] = 0; 
        }

        for(i = 0; i < s1Length; i++){
            for(j = 0; j < s1Length; j++){
                if(s1.charAt(j) == s2.charAt(i)){
                    System.out.println(s1.charAt(j) + " == " + s2.charAt(i));
                    cc[i+1][j+1] = cc[i][j] + 1;
                    //System.out.println();
                }else{
                    cc[i+1][j+1] = Math.max(cc[i+1][j],cc[i][j+1]);
                }
            }
        }
        display(cc, s1Length);
        return cc[s1Length][s1Length];
        
    }

    public static void display(int[][] cc, int s1Length){
        for(int i = 0; i <= s1Length; i++){
            for(int j = 0; j <= s1Length; j++){
                System.out.print(cc[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}


/* Output
0 0 0 0 0 0 0 0 0 
0 0 0 0 1 1 1 1 1 
0 0 0 0 1 1 1 1 1 
0 0 1 1 1 1 2 2 2 
0 0 1 1 1 1 2 3 3 
0 0 1 1 1 1 2 3 3 
0 0 1 1 1 1 2 3 3 
0 0 1 1 1 1 2 3 3 
0 0 1 1 1 1 2 3 3 
/*
