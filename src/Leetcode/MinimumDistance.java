// 3740. Minimum Distance Between Three Equal Elements I
// https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistance {
    public static void main(String[] args){
        MinimumDistance minimumDistance = new MinimumDistance();
        System.out.println(minimumDistance.minimumDistance(new int[]{1, 2, 1, 1, 3})); // 6
        System.out.println(minimumDistance.minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2})); // 8
        System.out.println(minimumDistance.minimumDistance(new int[]{1})); // -1
    }

    public int minimumDistance(int[] nums){
        if(nums.length < 3){
            return -1;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size() < 3){
                continue;
            }
            // just grab 3 in a row, dist = 2*(k-i)  
            for(int i = 0; i + 2 < list.size(); i++){
                int distance = 2 * (list.get(i + 2) - list.get(i));
                minDistance = Math.min(minDistance, distance);
            }
        }
        if(minDistance == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minDistance;
        }
    }
}
