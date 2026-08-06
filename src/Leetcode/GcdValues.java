package Leetcode;
// 3312. Sorted GCD Pair Queries
// https://leetcode.com/problems/sorted-gcd-pair-queries/

public class GcdValues {
    public static void main(String[] args) {
        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        int[] cnt = new int[maxVal + 1];
        for (int num : nums) cnt[num]++;

        int[] multiples = new int[maxVal + 1];
        for (int g = 1; g <= maxVal; g++)
            for (int m = g; m <= maxVal; m += g)
                multiples[g] += cnt[m];

        long[] prefix = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            long total = (long) multiples[g] * (multiples[g] - 1) / 2;
            for (int m = 2 * g; m <= maxVal; m += g) total -= prefix[m];
            prefix[g] = total;
        }
        for (int g = 1; g <= maxVal; g++) prefix[g] += prefix[g - 1];

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;
            int lo = 1, hi = maxVal;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= target) hi = mid; else lo = mid + 1;
            }
            answer[i] = lo;
        }

        return answer;
    }
    
    public int[] gcdValues(int[] nums, long[] queries){
        int[] result = new int[queries.length];

        return result;
    }
}
