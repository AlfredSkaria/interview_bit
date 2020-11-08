import java.io.*;
import java.util.*;

class LongestSubstringWithKDistinctChars{
    

    private static int getLongestSubstring(String str, int k, int strLen){

        int windowEnd = 0, windowStart = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> charCount = new HashMap<>();
        for(windowEnd = 0; windowEnd < strLen; windowEnd++){
            if(charCount.get(str.charAt(windowEnd)) != null){
                charCount.put(str.charAt(windowEnd), charCount.get(str.charAt(windowEnd)) + 1);
            }else{
                charCount.put(str.charAt(windowEnd), 1);
            }
            
            if(charCount.size() <= k){  
                maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            }else{
                while(charCount.size() > k){
                    charCount.put(str.charAt(windowStart), charCount.get(str.charAt(windowStart)) - 1);
                    if(charCount.get(str.charAt(windowStart)) == 0){
                        charCount.remove(str.charAt(windowStart));
                        System.out.println("char: " + str.charAt(windowStart) +" deleted");
                    }
                    windowStart++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        String input = "AAAHHHBC";
        int k = 2;
        int inLen = input.length();

        System.out.println("Longest substring with "+k+" distinct characters is: " + getLongestSubstring(input,k, inLen));
    }
}
