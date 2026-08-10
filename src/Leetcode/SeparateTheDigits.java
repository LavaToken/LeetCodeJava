// 2553. Separate the Digits in an Array
// https://leetcode.com/problems/separate-the-digits-in-an-array/description/
package Leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SeparateTheDigits {
    public static void main(String[] args) {
        int[] nums1 = {13,25,83,77};
        int[] expected1 = {1,3,2,5,8,3,7,7};
        int[] result1 = separateDigits(nums1);
        System.out.println("Expected: " + Arrays.toString(expected1) + " Result: " + Arrays.toString(result1));

        int[] nums2 = {7,1,3,9};
        int[] expected2 = {7,1,3,9};
        int[] result2 = separateDigits(nums2);
        System.out.println("Expected: " + Arrays.toString(expected2) + " Result: " + Arrays.toString(result2));
    }

    // Count digits, then extract with % / into a sized int[]
    public static int[] separateDigits(int[] nums) {
        int total = 0;
        for (int num : nums) {
            for (int n = num; n > 0; n /= 10) {
                total++;
            }
        }
        int[] res = new int[total];
        int idx = total;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int n = nums[i]; n > 0; n /= 10) {
                res[--idx] = n % 10;
            }
        }
        return res;
    }

    public static int[] separateDigitsOld(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            String convert = Integer.toString(nums[i]);
            for(int j = 0; j < convert.length(); j++){
                resList.add(Character.getNumericValue(convert.charAt(j)));
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
