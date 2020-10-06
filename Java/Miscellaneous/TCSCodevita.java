import java.io.*;
import java.util.*;

class TCSCodevita{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a,b,c,p1,p2,p3,q,e,r;
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        p3 = sc.nextInt();
        q = sc.nextInt();
        e = sc.nextInt();
        r = sc.nextInt();
        int res = (p1+p2+p3) -2*q;
        int f = e - r - res;
        a =  f/3;
        c = a + p1 + p3 - q;
        System.out.println(c);
        System.out.println(f);
    }
}