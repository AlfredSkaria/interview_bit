import java.io.*;
import java.util.*;

public class MatrixSpiralView{

    private void getSpiralView(int[][] mat, int row, int col){
        int i = 0, k = 0, l = 0;
        while(k < row && l < col){
            //left to right
            for(i = l; i < col; i++){
                System.out.print(mat[k][i]);
            }
            k++;

            //top to bottom
            for(i = k; i < row; i++){
                System.out.print(mat[i][col-1]);
            }
            col--;

            //right to left
            if(k < row){
                for(i = col-1; i >= l; i--){
                    System.out.print(mat[row-1][i]);
                }
                row--;
            }

            //bottom to top
            if(l < col){
                for(i = row-1; i >= k; i--){
                    System.out.print(mat[i][l]);
                }
                l++;
            }
        }
    }


    private void display(int[][] mat){
        int col = mat[0].length;
        int row = mat.length;
        System.out.println("row size: " + row + " col size: " + col);
    }

    public static void main(String args[]){
        MatrixSpiralView msv = new MatrixSpiralView();
        int[][] matrix = new int[][]{{3,4,5,6}, {8,9,1,2}, {3,4,5,9}};
        int col = matrix[0].length;
        int row = matrix.length;
        msv.display(matrix);
        msv.getSpiralView(matrix, row, col);
    }
}