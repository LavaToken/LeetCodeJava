package Leetcode;
// 3658. GCD of Odd and Even Sums
// https://leetcode.com/problems/gcd-of-odd-and-even-sums/

public class GcdOfOddEvenSums {
    public static void main(String[] args){
        System.out.println(new GcdOfOddEvenSums().gcdOfOddEvenSums(4)); // Should be 4
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        // first n odd numbers: 1, 3, 5, ... and first n even: 2, 4, 6, ...
        for (int i = 0; i < n; i++) {
            sumOdd += 2 * i + 1;
            sumEven += 2 * (i + 1);
        }
        return gcd(sumOdd, sumEven);
    }

    public int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
