// 1. Two Sum
// https://leetcode.com/problems/two-sum/
import java.util.*;

public class TwoSum {
    
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Expected: " + Arrays.toString(expected) + " Result: " + Arrays.toString(result));
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
