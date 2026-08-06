// 3016. Minimum NUmber of Pushes to Type Word II
// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

import java.util.Arrays;
import java.util.Collections;

public class MinimumNumPushes2 {
    public static void main(String[] args) {
        String word1 = "abcde";
        int expected1 = 5;
        int result1 = minimumPushes(word1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        String word2 = "xyzxyzxyzxyz";
        int expected2 = 12;
        int result2 = minimumPushes(word2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        String word3 = "aabbccddeeffgghhiiiiii";
        int expected3 = 24;
        int result3 = minimumPushes(word3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
    }

    public static int minimumPushes(String word) {
        int n = word.length();
        int[] count = new int[26];
        for(int i = 0; i < n; i++){
            count[word.charAt(i) - 'a']++;
        }
        // Sort count array
        Arrays.sort(count);

        int output = 0;
        int j = 0;
        for(int i = count.length - 1; i >= 0; i--){
            output += count[i] * (j / 8 + 1);
            j++;
            if(count[i] == 0){
                break;
            }
        }

        return output;
    }
}
