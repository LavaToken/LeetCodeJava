/*
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.ArrayList;

public class LengthOfLongestSubstring {
    public static void main(String[] args){
        ArrayList<String> prompts = new ArrayList<>();
        prompts.add("abcabcbb");
        prompts.add("bbbbb");
        prompts.add("pwwkew");
        prompts.add("aab");
        prompts.add("dvdf");
        for(int i = 0; i < prompts.size(); i++){
            String prompt = prompts.get(i);
            System.out.println(subLength(prompt));
        }
    }

    public static int subLength(String str) {
        int count = 0;
        int max = 0;
        int index;
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);
            if (!letters.contains(letter)) {
                letters.add(letter);
                count = letters.size();
                if (count > max) {
                    max = count;
                }
            } else {
                index = letters.indexOf(letter);
                ArrayList<String> temp = letters;
                letters = new ArrayList<String>();
                for(int j = index + 1; j < temp.size(); j++){
                    letters.add(temp.get(j));
                }
                letters.add(letter);
                count = letters.size();
            }
        }
        return max;
    }
}

class Node {
    int val;
    ArrayList<String> str;
    Node(int val, ArrayList<String> str) {
        this.val = val;
        this.str = str;
    }
}
