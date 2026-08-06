// 486. Predict the Winner
// https://leetcode.com/problems/predict-the-winner/

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 2};
        boolean expected1 = false;
        boolean result1 = predictTheWinner(nums1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        int[] nums2 = {1, 5, 233, 7};
        boolean expected2 = true;
        boolean result2 = predictTheWinner(nums2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);
        
        int[] nums3 = {2, 52, 49, 5, 2};
        boolean expected3 = false;
        boolean result3 = predictTheWinner(nums3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
        
    }

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = nums[i];
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0; // Player 1 wins if the difference is non-negative
    }
}
