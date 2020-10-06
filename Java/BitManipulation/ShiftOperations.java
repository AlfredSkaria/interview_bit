import java.io.*;
import java.util.*;

class ShiftOperations{

    public static void main(String args[]){
        int n = 50; //1010
        System.out.println("Left shift the number by 1 bit: " + (n<<1)); 
        System.out.println("Right shift the number by 1 bit: " + (n>>1)); 
        System.out.println("Left shift the number by 1 bit: " + (n<<3)); // n = n * (2 ^ 3) = 50 * 8 = 400
        System.out.println("Left shift the number by 1 bit: " + (n>>4)); // n = n / (2 ^ 4) = 50 / 16 = 3
    }
}