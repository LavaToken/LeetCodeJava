package Leetcode;
// 3513. Number of Unique XOR Triplets I
// https://leetcode.com/problems/number-of-unique-xor-triplets-i/

// nums[] of length n, containing permutation of 1 to n

import java.lang.Integer;
import java.lang.Math;

public class NumberOfUniqueXOR {
    public static void main(String[] args){
        int[] nums = {1,2};
        int expected = 2;
        System.out.println("Output: " + uniqueXorTriplets(nums) + " Expected: " + expected);

        int[] nums2 = {3,1,2};
        int expected2 = 4;
        System.out.println("Output: " + uniqueXorTriplets(nums2) + " Expected: " + expected2);

        int[] nums3 = {1,2,3,4,5};
        int expected3 = 8;
        System.out.println("Output: " + uniqueXorTriplets(nums3) + " Expected: " + expected3);

        // Test xor on {1,2,3,4,5}
        // Expected output: 7 unique
        // 5 -> 101 binary (3-bit)
        // 7 = (2^3) - 1
        // Maybe solution: (2^n) - 1 (n in binary)
        /*
        int[] nums2 = {1,2,3,4,5};
        for(int i = 0; i < nums2.length; i++){
            for(int j = i + 1; j < nums2.length; j++){
                for(int k = j + 1; k < nums2.length; k++){
                    System.out.println("XOR of " + nums2[i] + ", " + nums2[j] + ", " + nums2[k] + " is " + (nums2[i] ^ nums2[j] ^ nums2[k]));
                }
            }
        }
        for(int i = 0; i < nums2.length; i++){
            System.out.println("XOR of " + nums2[i] + " is " + (nums2[i] ^ nums2[i]));
        }
        */
    }

    
    public static int uniqueXorTriplets(int[] nums){
        if(nums.length == 2){
            return 2;
        }else if(nums.length == 1){
            return 1;
        }
        return (int)Math.pow(2, Integer.toBinaryString(nums.length).length());
    }
}
