package Leetcode;
// 1291. Sequential Digits
// https://leetcode.com/problems/sequential-digits/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SequentialDigits {
    public static void main(String[] args){
        SequentialDigits sequentialDigits = new SequentialDigits();
        int low = 100;
        int high = 300;
        List<Integer> result = sequentialDigits.sequentialDigits(low, high);
        System.out.println(result);
    }

    public List<Integer> sequentialDigits(int low, int high){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            while(num <= high){
                if(num >= low){
                    result.add(num);
                }
                int lastDigit = num % 10;
                if(lastDigit == 9){
                    break;
                }
                num = num * 10 + lastDigit + 1;
            }
        }
        Collections.sort(result);
        return result;
    }
}