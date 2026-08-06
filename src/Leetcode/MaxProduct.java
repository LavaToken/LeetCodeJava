package Leetcode;
// 1464. Maximum Product of Two Elements in an Array
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaxProduct {
    public static void main(String[] args){
        int[] nums = new int[]{3,4,5,2};
        System.out.println(maxProduct(nums));

        nums = new int[]{1,5,4,5};
        System.out.println(maxProduct(nums));

        nums = new int[]{3,7};
        System.out.println(maxProduct(nums));
    }
    
    public static int maxProduct(int[] nums) {
        int largest = 0;
        int second = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > largest){
                second = largest;
                largest = nums[i];
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return (largest - 1) * (second - 1);
    }
}