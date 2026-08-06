// 3345. Smallest Divisible Digit Product I
// https://leetcode.com/problems/smallest-divisible-digit-product-i/

import java.util.*;

public class SmallestDivisibleDigitProduct {
    public static void main(String[] args) {
        int n1 = 10; int t1 = 2;
        int expected1 = 10;
        int result1 = smallestNumer(n1, t1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        int n2 = 15; int t2 = 3;
        int expected2 = 16;
        int result2 = smallestNumer(n2, t2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        int n3 = 100; int t3 = 4;
        int expected3 = 100;
        int result3 = smallestNumer(n3, t3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);

        int n4 = 7; int t4 = 6;
        int expected4 = 10;
        int result4 = smallestNumer(n4, t4);
        System.out.println("Expected: " + expected4 + " Result: " + result4);
    }

    public static int smallestNumer(int n, int t){
        if(n == 100){
            return 100;
        }
        if(n > 9){
            int prod;
            for(int i = n; i < 101; i++){
                prod = (i / 10) * (i % 10);
                if(prod % t == 0){
                    return i;
                }
            }
        }
        for(int i = n; i < 11; i++){
            if(i % t == 0){
                return i;
            }
        }
        return 10;
    }
}
