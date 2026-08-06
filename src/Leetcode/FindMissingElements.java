package Leetcode;
// 3731. Find Missing Elements
// https://leetcode.com/problems/find-missing-elements/description/

import java.util.*;

public class FindMissingElements {
    public static void main(String[] args) {
        int[] input1 = {1,4,2,5};
        List<Integer> expected1 = Arrays.asList(3);
        List<Integer> result1 = findMissingElements(input1);
        System.out.println("Expected: " + expected1);
        System.out.println("Result: " + result1);

        int[] input2 = {7,8,6,9};
        List<Integer> expected2 = Arrays.asList();
        List<Integer> result2 = findMissingElements(input2);
        System.out.println("Expected: " + expected2);
        System.out.println("Result: " + result2);

        int[] input3 = {5,1};
        List<Integer> expected3 = Arrays.asList(2,3,4);
        List<Integer> result3 = findMissingElements(input3);
        System.out.println("Expected: " + expected3);
        System.out.println("Result: " + result3);
    }

    public static List<Integer> findMissingElements2(int[] nums) {
        List<Integer> missingElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingElements.add(i + 1);
            }
        }
        return missingElements;
    }

    public static List<Integer> findMissingElements(int[] nums) {
        int min = 100;
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int[] newNums = new int[max - min + 1];
        for(int i = 0; i < nums.length; i++){
            newNums[nums[i] - min] = 1;
        }
        List<Integer> missing = new ArrayList<>();
        for(int i = 0; i < newNums.length; i++){
            if(newNums[i] != 1){
                missing.add(i + min);
            }
        }
        return missing;
    }
}
