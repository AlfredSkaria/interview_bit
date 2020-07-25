import java.io.*;
import java.util.*;

public class LongestPalindromeSubsequence {
    public static void main(String args[]) {
      System.out.println("");
      String s = "aagbdbaa";
      System.out.println("Longest palindromic subsequence length: " + getLengthOfSubsequence(s));
      
    }
    
    public static int getLengthOfSubsequence(String s){
        int n = s.length();
        System.out.println("String length: " + n);
        int subSeq[][] = new int[n][n];
        int i=0,j=0,l=1,subSeqLength=0;
        fillDiagonalElements(subSeq,n);
            while(l<=n){
                for(i = 0; i+l < n; i++){
                    if(s.charAt(i) == s.charAt(i+l)){
                        subSeq[i][i+l] = subSeq[i+1][i+l-1] + 2;
                    }else{
                        subSeq[i][i+l] = Math.max(subSeq[i][i+l-1],subSeq[i+1][i+l]);
                    }
                }
                
                l++;
            }
            subSeqLength = subSeq[0][n-1]; 
            displayMatrix(subSeq, n);
            return subSeqLength;
        }
        
        
        public static void fillDiagonalElements(int subSeq[][], int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                if(i==j){
                    subSeq[i][j] = 1;
                }
            }
        }
    }
    
    public static void displayMatrix(int matrix[][], int n){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}
    
    
