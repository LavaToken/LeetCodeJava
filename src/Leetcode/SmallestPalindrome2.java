package Leetcode;
// 3518. Smallest Palindromic Rearrangement II
// https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/

public class SmallestPalindrome2 {
    public static void main(String[] args) {
        String s1 = "abba";
        int k1 = 2;
        String expected1 = "baab";
        String result1 = smallestPalindrome(s1, k1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        String s2 = "aa";
        int k2 = 2;
        String expected2 = "";
        String result2 = smallestPalindrome(s2, k2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        String s3 = "bacab";
        int k3 = 1;
        String expected3 = "abcba";
        String result3 = smallestPalindrome(s3, k3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
    }

    public static String smallestPalindrome(String s, int k) {
        final int MAX = 1_000_001;
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        char[] left = new char[halfLen];
        // pos == -1: only check total arrangements; pos >= 0: fill left[pos]
        for (int pos = -1; pos < halfLen; pos++) {
            boolean placed = false;
            for (int c = 0; c < 26; c++) {
                if (pos >= 0 && half[c] == 0) {
                    continue;
                }
                if (pos >= 0) {
                    half[c]--;
                }

                // Distinct permutations of remaining multiset: rem! / (h0! * h1! * ...)
                int rem = 0;
                for (int h : half) {
                    rem += h;
                }
                long ways = 1;
                for (int h : half) {
                    if (h == 0) {
                        continue;
                    }
                    int choose = Math.min(h, rem - h);
                    long nCk = 1;
                    for (int i = 1; i <= choose; i++) {
                        long num = rem - i + 1;
                        if (nCk > Long.MAX_VALUE / num) {
                            nCk = MAX;
                            break;
                        }
                        nCk = nCk * num / i;
                        if (nCk >= MAX) {
                            nCk = MAX;
                            break;
                        }
                    }
                    if (ways >= MAX || nCk >= MAX || ways > (MAX - 1) / nCk) {
                        ways = MAX;
                        break;
                    }
                    ways *= nCk;
                    rem -= h;
                }

                if (pos < 0) {
                    if (ways < k) {
                        return "";
                    }
                    placed = true;
                    break;
                }

                if (ways >= k) {
                    left[pos] = (char) ('a' + c);
                    placed = true;
                    break;
                }
                k -= (int) ways;
                half[c]++;
            }
            if (!placed) {
                return "";
            }
        }

        char[] ans = new char[n];
        for (int i = 0; i < halfLen; i++) {
            ans[i] = left[i];
            ans[n - 1 - i] = left[i];
        }
        if (mid != 0) {
            ans[n / 2] = mid;
        }
        return new String(ans);
    }
}
