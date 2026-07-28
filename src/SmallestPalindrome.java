// 3517. Smallest Palindrome Rearrangement I
// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SmallestPalindrome {
    public static void main(String[] args){
        String input1 = "z";
        String expected1 = "z";
        String result1 = smallestPalindrome(input1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        String input2 = "babab";
        String expected2 = "abbba";
        String result2 = smallestPalindrome(input2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        String input3 = "daccad";
        String expected3 = "acddca";
        String result3 = smallestPalindrome(input3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);

        String input4 = "racecar";
        String expected4 = "acrerca";
        String result4 = smallestPalindrome(input4);
        System.out.println("Expected: " + expected4 + " Result: " + result4);

        String input5 = "abcabcbacba";
        String expected5 = "aabbcccbbaa";
        String result5 = smallestPalindrome(input5);
        System.out.println("Expected: " + expected5 + " Result: " + result5);

        String input6 = "inini";
        String expected6 = "inini";
        String result6 = smallestPalindrome(input6);
        System.out.println("Expected: " + expected6 + " Result: " + result6);
        
    }

    public static String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                ans[left++] = ans[right--] = (char) ('a' + i);
                freq[i] -= 2;
            }
            if (freq[i] == 1) {
                ans[n / 2] = (char) ('a' + i);
            }
        }
        return new String(ans);
    }

    // Previous HashMap + sort + StringBuilder solution
    public static String smallestPalindromeOld(String s){
        int length = s.length();

        if (length == 1) {
            return s;
        }
        // 1. Create set counting the frequency of each character
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // 2. Sort characters by lexicographical order
        List<Character> characters = new ArrayList<>(frequency.keySet());
        Collections.sort(characters);

        // 3. Identify middle character: Character in frequency set with odd number of occurences
        char middleCharacter = ' ';
        for (char c : characters) {
            if (frequency.get(c) % 2 == 1) {
                middleCharacter = c;
                break;
            }
        }

        // 4. Build first half with n/2 of each character (sorted)
        StringBuilder half = new StringBuilder();
        for (char c : characters) {
            for (int i = 0; i < frequency.get(c) / 2; i++) {
                half.append(c);
            }
        }

        // 5. Assemble palindrome: half + middle + reverse(half)
        StringBuilder result = new StringBuilder(half);
        if (middleCharacter != ' ') {
            result.append(middleCharacter);
        }
        result.append(half.reverse());

        return result.toString();
    }
}
