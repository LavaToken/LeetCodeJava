// 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingInteger {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 5};
        int expected1 = 6, output1 = missingInteger(nums1);
        System.out.println(output1 == expected1);

        int[] nums2 = {3,4,5,1,12,14,13};
        int expected2 = 15, output2 = missingInteger(nums2);
        System.out.println(output2 == expected2);

        int[] nums3 = {46,8,2,4,1,4,10,2,4,10,2,5,7,3,1};
        int expected3 = 47, output3 = missingInteger(nums3);
        System.out.println(output3 == expected3);

    }

    public static int missingInteger(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){ // prefix sum
            if(nums[i] != min + 1){
                break;
            }
            sum += nums[i];
            min = nums[i];
        }

        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            seen.add(nums[i]);
        }
        int smallest = sum;
        while(seen.contains(smallest)){
            smallest++;
        }
        return smallest;
    }
}
