// 3499. Maximize Active Section with Trade-1
// https://leetcode.com/problems/maximize-active-section-with-trade-i/

import java.util.*;
import java.util.ArrayList;

public class MaxActiveSection {
    public static void main(String[] args){
        String input = "Input: ";
        String output = "Output: ";
        String expected = "Expected: ";
        
        String s1 = "01";
        int expected1 = 1;
        System.out.println(input + s1 + "\n" + output + maxActiveSectionsAfterTrade(s1) + "\n" + expected + expected1);

        String s2 = "0100";
        int expected2 = 4;
        System.out.println(input + s2 + "\n" + output + maxActiveSectionsAfterTrade(s2) + "\n" + expected + expected2);

        String s3 = "1000100";
        int expected3 = 7;
        System.out.println(input + s3 + "\n" + output + maxActiveSectionsAfterTrade(s3) + "\n" + expected + expected3);

        String s4 = "01010";
        int expected4 = 4;
        System.out.println(input + s4 + "\n" + output + maxActiveSectionsAfterTrade(s4) + "\n" + expected + expected4);

        String s5 = "001";
        int expected5 = 1;
        System.out.println(input + s5 + "\n" + output + maxActiveSectionsAfterTrade(s5) + "\n" + expected + expected5);

        String s6 = "11011100";
        int expected6 = 8;
        System.out.println(input + s6 + "\n" + output + maxActiveSectionsAfterTrade(s6) + "\n" + expected + expected6);

        String s7 = "1110111";
        int expected7 = 6;
        System.out.println(input + s7 + "\n" + output + maxActiveSectionsAfterTrade(s7) + "\n" + expected + expected7);

        String s8 = "10010010001";
        int expected8 = 8;
        System.out.println(input + s8 + "\n" + output + maxActiveSectionsAfterTrade(s8) + "\n" + expected + expected8);

        String s9 = "0000";
        int expected9 = 0;
        System.out.println(input + s9 + "\n" + output + maxActiveSectionsAfterTrade(s9) + "\n" + expected + expected9);

        String s10 = "1111";
        int expected10 = 4;
        System.out.println(input + s10 + "\n" + output + maxActiveSectionsAfterTrade(s10) + "\n" + expected + expected10);

        String s11 = "10111010001";
        int expected11 = 9;
        System.out.println(input + s11 + "\n" + output + maxActiveSectionsAfterTrade(s11) + "\n" + expected + expected11);

        String s12 = "0001000";
        int expected12 = 6;
        System.out.println(input + s12 + "\n" + output + maxActiveSectionsAfterTrade(s12) + "\n" + expected + expected12);

        String s13 = "11011011";
        int expected13 = 6;
        System.out.println(input + s13 + "\n" + output + maxActiveSectionsAfterTrade(s13) + "\n" + expected + expected13);
    
        String s14 = "00";
        int expected14 = 0;
        System.out.println(input + s14 + "\n" + output + maxActiveSectionsAfterTrade(s14) + "\n" + expected + expected14);
    }

    public static int maxActiveSectionsAfterTrade(String s){
        String t = '1' + s + '1';
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> zeros = new ArrayList<>();
        int count1 = 0;
        int count0 = 0;
        int finCount = 0;
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '1'){
                if(count0 > 0){
                    zeros.add(count0);
                    count0 = 0;
                }
                count1++;
                if(i != 0 && i != t.length()-1){
                    finCount++;
                }
            }else{
                if(count1 > 0){
                    ones.add(count1);
                    count1 = 0;
                }
                count0++;
            }
        }
        ones.add(1);
        int max = 0;
        int count = 0;
        for(int i = 1; i < ones.size() - 1; i++){
            count = zeros.get(i-1) + zeros.get(i);
            if(count > max){
                max = count;
            }
        }
        System.out.println("finCount: " + finCount);
        System.out.println("Max: " + max);
        return finCount + max;
    }

    public static int maxActiveSectionsAfterTrade2(String s){
        String t = '1' + s + '1';
        int max = 0;
        int count = 0;
        int trade = 0; // trade = 0: no block of '1's; trade = 1: iterating through block; trade = 2: trade finished, ready to reset
        boolean active = false;
        int finCount = 0;
        for(int i = 1; i < t.length(); i++){
            if(t.charAt(i) == '0'){
                if(!active){
                    active = true;
                }
                if(trade == 1){
                    trade++;
                }
                count++;
            }else if(t.charAt(i) == '1' && active){
                if(trade < 1){
                    trade++;
                }else if(trade == 1){
                    continue;
                }else if(trade >= 2){
                    if(count > max){
                        max = count;
                    }
                    active = false;
                    count = 0;
                    trade = 0;
                }
            }
        }
        
        for(int i = 1; i < t.length()-1; i++){
            if(t.charAt(i) == '1'){
                finCount++;
            }
        }
        return finCount + max;
    }
}
