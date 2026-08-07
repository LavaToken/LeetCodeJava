// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

package NeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input1 = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> expected1 = new ArrayList<>(Arrays.asList(Arrays.asList("hat"), Arrays.asList("act", "cat"), Arrays.asList("stop", "pots", "tops")));
        List<List<String>> result1 = groupAnagrams(input1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        String[] input2 = {"x"};
        List<List<String>> expected2 = new ArrayList<>(Arrays.asList(Arrays.asList("x")));
        List<List<String>> result2 = groupAnagrams(input2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        String[] input3 = {""};
        List<List<String>> expected3 = new ArrayList<>(Arrays.asList(Arrays.asList("")));
        List<List<String>> result3 = groupAnagrams(input3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}