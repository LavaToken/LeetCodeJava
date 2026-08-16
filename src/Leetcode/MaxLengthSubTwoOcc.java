// 3090. Maximum Length Substring With Two Occurences
// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
// Given a string s, return the maximum length of a substring that contains at most two occurences of each character

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubTwoOcc {
    public static void main(String[] args) {
        String s1 = "bcbbbcba";
        int expected1 = 4;
        int result1 = maximumLengthSubstring(s1);
        System.out.println("Expected: " + expected1 + ", Result: " + result1);

        String s2 = "aaaa";
        int expected2 = 2;
        int result2 = maximumLengthSubstring(s2);
        System.out.println("Expected: " + expected2 + ", Result: " + result2);

        String s3 = "baaaaab";
        int expected3 = 3;
        int result3 = maximumLengthSubstring(s3);
        System.out.println("Expected: " + expected3 + ", Result: " + result3);
    }

    public static int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            while (charCount.get(rightChar) > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}