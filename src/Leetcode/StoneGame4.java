package Leetcode;
// 1510. Stone Game IV
// https://leetcode.com/problems/stone-game-iv/description/

import java.util.Arrays;

public class StoneGame4 {
    public static void main(String[] args) {
        int n1 = 1;
        boolean expected1 = true;
        boolean result1 = stoneGameIII(n1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        int n2 = 2;
        boolean expected2 = false;
        boolean result2 = stoneGameIII(n2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        int n3 = 4;
        boolean expected3 = true;
        boolean result3 = stoneGameIII(n3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
    }

    public static boolean stoneGameIII(int n) { // something is wrong
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
