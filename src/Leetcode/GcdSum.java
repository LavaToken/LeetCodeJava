// 3867. Sum of GCD of Formed Pairs
// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

import java.util.Arrays;

public class GcdSum {
    public static void main(String[] args){
        int[] arr1 = {2, 6, 4}; // Should be 2
        int sum = gcdSum(arr1);
        System.out.println(sum);

        int[] arr2 = {3, 6, 2, 8}; // Should be 5
        int sum2 = gcdSum(arr2);
        System.out.println(sum2);
        
        int[] arr3 = {1, 2, 3, 4, 5};
        int sum3 = gcdSum(arr3);
        System.out.println(sum3);
    }

    public static long gcdSum(int[] nums){
        int mx = 0;
        long[] prefixGcd = new long[nums.length];
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > mx){
                mx = nums[i];
            }
            prefixGcd[i] = gcd(nums[i], mx);
        }
        // Using in-place QuickSort for better average case performance on primitive arrays
        quickSort(prefixGcd, 0, prefixGcd.length - 1);

        for(int i = 0; i < prefixGcd.length/2; i++){
            count += gcd(prefixGcd[i], prefixGcd[prefixGcd.length - i - 1]);
        }
        return count;
    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  
            quickSort(arr, pi + 1, high); 
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}