import java.io.*;
import java.util.*;

class CountSetBits{

    public static void main(String args[]){

        int n, count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        n = sc.nextInt();
        while( n > 0){
            if((n & 1) > 0){
                count ++;
            }
            n = n >> 1;
        }

        System.out.println("number of set bits in "+n+" is: " + count);
    }
}