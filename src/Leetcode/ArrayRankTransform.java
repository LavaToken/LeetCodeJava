package Leetcode;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayRankTransform {
    public static void main(String[] args){
        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();
        int[] nums = {40, 10, 20, 30};
        int[] result = arrayRankTransform.arrayRankTransform(nums);
        System.out.println(Arrays.toString(result));

        int[] nums2 = {100, 100, 100};
        int[] result2 = arrayRankTransform.arrayRankTransform(nums2);
        System.out.println(Arrays.toString(result2));

        int[] nums3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] result3 = arrayRankTransform.arrayRankTransform(nums3);
        System.out.println(Arrays.toString(result3));
        int[] ans = {5, 3, 4, 2, 8, 6, 7, 1, 3};
    }
    
    public int[] arrayRankTransform(int[] arr){
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = rank.get(arr[i]);
        }
        return ans;
    }
}