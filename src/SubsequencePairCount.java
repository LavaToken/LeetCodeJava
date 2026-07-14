// 3336. Find the Number of Subsequences With Equal GCD
// https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

import java.util.Arrays;

public class SubsequencePairCount {
    public static void main(String[] args){
        SubsequencePairCount solution = new SubsequencePairCount();
        int[] nums = {1, 2, 3, 4};
        int result = solution.subsequencePairCount(nums);
        System.out.println(result); // expected: 10

        int[] nums2 = {10, 20, 30};
        int result2 = solution.subsequencePairCount(nums2);
        System.out.println(result2); // expected: 2

        int[] nums3 = {1, 1, 1, 1};
        int result3 = solution.subsequencePairCount(nums3);
        System.out.println(result3); // expected: 50
    }

    public int subsequencePairCount(int[] nums){
        int maxNum = Arrays.stream(nums).max().getAsInt();
        Integer[][][] memo = new Integer[nums.length][maxNum + 1][maxNum + 1];
        return dfs(nums, 0, 0, 0, memo);
    }

    // lazy split nums[i..] into two piles, track gcds (x and y, 0 = nothing there yet)
    private int dfs(int[] nums, int i, int x, int y, Integer[][][] memo){
        if(i == nums.length){
            return (x > 0 && x == y) ? 1 : 0;
        }
        if(memo[i][x][y] != null){
            return memo[i][x][y];
        }

        // just skip nums[i]
        int skip = dfs(nums, i + 1, x, y, memo);
        // shove nums[i] in first pile
        int take1 = dfs(nums, i + 1, gcd(x, nums[i]), y, memo);
        // shove nums[i] in second pile
        int take2 = dfs(nums, i + 1, x, gcd(y, nums[i]), memo);

        return memo[i][x][y] = (int)(((long)skip + take1 + take2) % 1_000_000_007);
   
   
    }

    private int gcd(int a, int b){
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
   
    }
}
