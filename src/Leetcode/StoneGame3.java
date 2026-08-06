package Leetcode;
// 1406. Stone Game III
// https://leetcode.com/problems/stone-game-iii/description/

public class StoneGame3 {
    public static void main(String[] args) {
        int[] stoneValue = {1,2,3,7};
        String expected = "Bob";
        String result = stoneGameIII(stoneValue);
        System.out.println("Expected: " + expected + " Result: " + result);

        int[] stoneValue2 = {1,2,3,-9};
        String expected2 = "Alice";
        String result2 = stoneGameIII(stoneValue2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        int[] stoneValue3 = {1,2,3,6};
        String expected3 = "Tie";
        String result3 = stoneGameIII(stoneValue3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
    }

    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = stoneValue[i] - dp[i + 1];
            if(i + 2 <= n){
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
            }
            if(i + 3 <= n){
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
            }
        }
        if(dp[0] > 0){
            return "Alice";
        } else if(dp[0] < 0){
            return "Bob";
        }
        return "Tie";
    }
}
