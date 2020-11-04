import java.util.*;
import java.lang.*;
import java.io.*;

class LongestRepeatingCharacterReplacement
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "ABAABABB";
		int k = 2;
		int N = str.length();
		int out = getLongestSubstringWithSameCharacters(str,N,k);
		System.out.println("Longest Substring With Same Characters: " + out);
	}
	
	public static int getLongestSubstringWithSameCharacters(String str,int N,int k){
	    int windowStart = 0, windowEnd = 0, maxCount = 0, maxLength = 0;
	    int[] charCount = new int[26];
	    for(windowEnd = 0; windowEnd < N; windowEnd++){
	        charCount[str.charAt(windowEnd)-'A']++;
	        int charCnt = charCount[str.charAt(windowEnd)-'A'];
	        maxCount = Math.max(maxCount, charCnt);
	        while(windowEnd - windowStart - maxCount + 1 > k){
	            charCount[str.charAt(windowStart)-'A']--;
	            windowStart ++;
	        }
	        
	        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	        
	    }
	    return maxLength;
	}
}
