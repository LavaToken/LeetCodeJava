// 217. Contains Duplicate

package NeetCode;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        boolean expected1 = true;
        boolean result1 = hasDuplicate(nums1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        int[] nums2 = {1, 2, 3, 4};
        boolean expected2 = false;
        boolean result2 = hasDuplicate(nums2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);;
    }
    
    // Benefit of hashset over arraylist is that it is more efficient for searching and inserting
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> dup = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(dup.contains(nums[i])){
                return true;
            }
            dup.add(nums[i]);
        }
        return false;
    }

}
