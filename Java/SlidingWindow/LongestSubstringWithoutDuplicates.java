import java.util.*;
import java.lang.*;
import java.io.*;

class LongestSubstringWithoutDuplicates
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    String str = "abrexrzx";
	    int strLength = str.length();
	    int window_start = 0, window_end = 0, maxCount = 0;
	    int[] charCnt = new int[300];
	    while(window_end !=  strLength){
	        if(charCnt[str.charAt(window_end)] == 0){
	            charCnt[str.charAt(window_end)] =1;
	            maxCount = Math.max(maxCount, window_end - window_start + 1);
	            window_end ++;
	           
	        }else{
	            charCnt[str.charAt(window_start)] --;
	            window_start ++;
	        }
	    }
	    
	    System.out.println("Longest substring count without duplicates: " + maxCount);
	}
}
