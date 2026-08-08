// 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/
package Leetcode;

import java.util.Arrays;
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6};
        int target1 = 5;
        int expected1 = 2, output1 = searchInsert(nums1, target1);
        System.out.println("Expected: " + expected1 + " Output: " + output1);

        int[] nums2 = {1,3,5,6};
        int target2 = 2;
        int expected2 = 1, output2 = searchInsert(nums2, target2);
        System.out.println("Expected: " + expected2 + " Output: " + output2);

        int[] nums3 = {1,3,5,6};
        int target3 = 7;
        int expected3 = 4, output3 = searchInsert(nums3, target3);
        System.out.println("Expected: " + expected3 + " Output: " + output3);
        
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(target > nums[i]){
                index++;
            }
        }
        return index;
    }
}
