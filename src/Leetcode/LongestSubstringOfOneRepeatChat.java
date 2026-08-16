// 2213. Longest Substring of One Repeating Character
// https://leetcode.com/problems/longest-substring-of-one-repeating-character

package Leetcode;
import java.util.*;
public class LongestSubstringOfOneRepeatChat {
    public static void main(String[] args){

    }

    public static int[] longestRepeating(String s, String queryCharacters, int[] queryIndices){

    }

    public static int[] longestRepeatingOld(String s, String queryCharacters, int[] queryIndices){
        char[] st = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            st[i] = s.charAt(i);
        }
        
        int[] result = new int[queryIndices.length];
        for(int i = 0; i < queryIndices.length; i++){
            st[queryIndices[i]] = queryCharacters.charAt(i);
            result[i] = longestChar(st);
        }
        return result;
    }

    public static int longestChar(char[] arr) {
        if (arr.length == 0) {
            return 0;
        }
    
        int maxLen = 1;
        int curLen = 1;
    
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
    
        return maxLen;
    }
}
