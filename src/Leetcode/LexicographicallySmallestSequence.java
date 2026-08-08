// 3302. Find the Lexicographically Smallest Valid Sequence
// https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

package Leetcode;

import java.util.Arrays;

public class LexicographicallySmallestSequence {
    public static void main(String[] args){
        String x1 = "vbcca", y1 = "abc";
        int[] expected1 = {0,1,2}, result1 = validSequence(x1, y1);
        System.out.println("Expected: " + Arrays.toString(expected1) + " Result: " + Arrays.toString(result1));

        String x2 = "bacdc", y2 = "abc";
        int[] expected2 = {1,2,4}, result2 = validSequence(x2, y2);
        System.out.println("Expected: " + Arrays.toString(expected2) + " Result: " + Arrays.toString(result2));

        String x3 = "aaaaa", y3 = "aaabc";
        int[] expected3 = {}, result3 = validSequence(x3, y3);
        System.out.println("Expected: " + Arrays.toString(expected3) + " Result: " + Arrays.toString(result3));

        String x4 = "abc", y4 = "ab";
        int[] expected4 = {0,1}, result4 = validSequence(x4, y4);
        System.out.println("Expected: " + Arrays.toString(expected4) + " Result: " + Arrays.toString(result4));

        String x5 = "ccbccccbcc", y5 = "b";
        int[] expected5 = {0}, result5 = validSequence(x5, y5);
        System.out.println("Expected: " + Arrays.toString(expected5) + " Result: " + Arrays.toString(result5));
    }

    /*
    Condition:
    1. String x is almost equal to y if you can change at most one character 
    2. Indices are sorted in ascending order
    3. Concatenating the characters at indices word1 in the same order results in a string that is almost equal to word2*/
    public static int[] validSequence(String word1, String word2){
        int n1 = word1.length(), n2 = word2.length();
        int[] dp = new int[n1 + 1];
        dp[n1] = 0;
        for(int i = n1 - 1; i >= 0; i--){
            dp[i] = dp[i + 1];
            if(dp[i + 1] < n2 && word1.charAt(i) == word2.charAt(n2 - 1 -dp[i + 1])){
                dp[i] = dp[i + 1] + 1;
            }
        }

        int[] result = new int[n2];
        int index = 0;
        boolean miss = false;

        for(int i = 0; i < n2; i++){
            int remaining = n2 - i - 1;
            if(index < n1 && word1.charAt(index) == word2.charAt(i)){
                result[i] = index;
                index++;
            }else if(!miss && index < n1 && dp[index + 1] >= remaining){
                result[i] = index;
                index++;
                miss = true;
            }else{
                int idx = -1;
                for(int j = index; j < n1; j++){
                    if(word1.charAt(j) == word2.charAt(i)){
                        idx = j;
                        break;
                    }
                }
                if(idx == -1){
                    return new int[0];
                }
                result[i] = idx;
                index = idx + 1;
            }
        }
        
        return result;
    }
}
