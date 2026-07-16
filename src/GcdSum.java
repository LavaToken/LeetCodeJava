// 3867. Sum of GCD of Formed Pairs
// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

import java.util.Arrays;

public class GcdSum {
    public static void main(String[] args){
        int[] arr1 = {2, 6, 4}; // Should be 2
        long sum = gcdSum(arr1);
        System.out.println(sum);

        int[] arr2 = {3, 6, 2, 8}; // Should be 5
        long sum2 = gcdSum(arr2);
        System.out.println(sum2);
        
        int[] arr3 = {1, 2, 3, 4, 5};
        long sum3 = gcdSum(arr3);
        System.out.println(sum3);
    }

    public static long gcdSum(int[] nums){
        int mx = 0;
        long[] prefixGcd = new long[nums.length];
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > mx){
                mx = nums[i];
            }
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);

        for(int i = 0; i < prefixGcd.length/2; i++){
            count += gcd(prefixGcd[i], prefixGcd[prefixGcd.length - i - 1]);
        }
        return count;
    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}