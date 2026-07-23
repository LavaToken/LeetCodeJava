// 3501. Maximize Active Section with Trade II
// https://leetcode.com/problems/maximize-active-section-with-trade-ii/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MaxActiveSection2 {
    public static void main(String[] args){
        String s1 = "01";
        int[][] queries1 = {{0,1}};
        int[] expected1 = {1};
        List<Integer> results1 = maxActiveSectionsAfterTrade(s1, queries1);
        System.out.println(results1 + "; " + Arrays.toString(expected1));

        String s2 = "0100";
        int[][] queries2 = {{0,3},{0,2},{1,3},{2,3}};
        int[] expected2 = {4,3,1,1};
        List<Integer> results2 = maxActiveSectionsAfterTrade(s2, queries2);
        System.out.println(results2 + "; " + Arrays.toString(expected2));

        String s3 = "1000100";
        int[][] queries3 = {{1,5},{0,6},{0,4}};
        int[] expected3 = {6,7,2};
        List<Integer> results3 = maxActiveSectionsAfterTrade(s3, queries3);
        System.out.println(results3 + "; " + Arrays.toString(expected3));

        String s4 = "01010";
        int[][] queries4 = {{0,3},{1,4},{1,3}};
        int[] expected4 = {4,4,2};
        List<Integer> results4 = maxActiveSectionsAfterTrade(s4, queries4);
        System.out.println(results4 + "; " + Arrays.toString(expected4));
    }

    public static List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries){
        List<Integer> results = new ArrayList<>();
        String t = s;
        int finCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                finCount++;
            }
        }
        for(int x = 0; x < queries.length; x++){
            t = '1' + s.substring(queries[x][0], queries[x][1] + 1) + '1';
            ArrayList<Integer> ones = new ArrayList<>();
            ArrayList<Integer> zeros = new ArrayList<>();
            int count1 = 0;
            int count0 = 0;
            for(int i = 0; i < t.length(); i++){
                if(t.charAt(i) == '1'){
                    if(count0 > 0){
                        zeros.add(count0);
                        count0 = 0;
                    }
                    count1++;
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
            results.add(finCount + max);
        }
        return results;      
    }
}