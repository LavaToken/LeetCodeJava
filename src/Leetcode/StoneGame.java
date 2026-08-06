package Leetcode;
// 877. Stone Game
// https://leetcode.com/problems/stone-game/

public class StoneGame {
    public static void main(String[] args) {
        int[] stones1 = {5, 3, 4, 5};
        boolean expected1 = true;
        boolean actual1 = stoneGame(stones1);
        System.out.println("Expected: " + expected1 + " Actual: " + actual1);
        System.out.println("Test Case 1: " + (expected1 == actual1 ? "Passed" : "Failed"));

        int[] stones2 = {3, 7, 2, 3};
        boolean expected2 = true;
        boolean actual2 = stoneGame(stones2);
        System.out.println("Expected: " + expected2 + " Actual: " + actual2);
        System.out.println("Test Case 2: " + (expected2 == actual2 ? "Passed" : "Failed"));
    }

    public static boolean stoneGame(int[] piles) { // Most optimal solution
        return true;
    }

    public static boolean stoneGameOld(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = -piles[i];
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
