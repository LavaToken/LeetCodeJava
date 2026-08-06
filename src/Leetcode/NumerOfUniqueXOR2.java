package Leetcode;
// 3514. Number of Unique XOR Triplets II
// https://leetcode.com/problems/number-of-unique-xor-triplets-ii/

import java.util.*;

public class NumerOfUniqueXOR2 {
    public static void main(String[] args){
        int[] nums1 = {1,3};
        int exp1 = 2;
        int result1 = uniqueXorTriplets(nums1);
        System.out.println("Output: " + result1 + " Expected: " + exp1);
        
        int[] nums2 = {6,7,8,8};
        int exp2 = 4;
        int result2 = uniqueXorTriplets(nums2);
        System.out.println("Output: " + result2 + " Expected: " + exp2);
    }

    public static int uniqueXorTriplets(int[] nums){
        // Reduce to V
        Set<Integer> unique = new HashSet<>();
        for(int x : nums){
            unique.add(x);
        }
        int[] V = new int[unique.size()];
        int idx = 0;
        for(int v : unique){
            V[idx++] = v;
        }

        // Computer all pairs XOR
        Set<Integer> pairXOR = new HashSet<>();
        for(int i = 0; i < V.length; i++){
            for(int j = i; j < V.length; j++){
                pairXOR.add(V[i] ^ V[j]);
            }
        }

        // XOR that pair-set against V
        Set<Integer> achievable = new HashSet<>();
        for(int v : V){
            for(int p : pairXOR){
                achievable.add(v ^ p);
            }
        }

        // Count V or everything marked achievable
        return achievable.size();
    }


    // Brute Force Solution
    public static int uniqueXorTripletsBruteForce(int[] nums){
        int n = nums.length;
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    results.add(nums[i] ^ nums[j] ^ nums[k]);
                }
            }
        }
        System.out.println(results);
        return results.size();
    }

}
