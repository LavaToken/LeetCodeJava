package Leetcode;
// 3310. Remove Methods From Project
// https://leetcode.com/problems/remove-methods-from-project/description/

import java.util.*;

public class RemoveMethods {
    public static void main(String[] args) {
        int n1 = 4;
        int k1 = 1;
        int[][] invocations1 = {{1,2},{0,1},{3,2}};
        List<Integer> expected1 = Arrays.asList(0,1,2,3);
        List<Integer> result1 = remainingMethods(n1, k1, invocations1);
        System.out.println("Expected: " + expected1 + " | Result: " + result1);

        int n2 = 5;
        int k2 = 0;
        int[][] invocations2 = {{1,2},{0,2},{0,1},{3,4}};
        List<Integer> expected2 = Arrays.asList(3,4);
        List<Integer> result2 = remainingMethods(n2, k2, invocations2);
        System.out.println("Expected: " + expected2 + " | Result: " + result2);

        int n3 = 3;
        int k3 = 2;
        int[][] invocations3 = {{1,2},{0,1},{2,0}};
        List<Integer> expected3 = Arrays.asList();
        List<Integer> result3 = remainingMethods(n3, k3, invocations3);
        System.out.println("Expected: " + expected3 + " | Result: " + result3);
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }

        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj.get(cur)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.add(next);
                }
            }
        }

        boolean canRemove = true;
        for (int[] inv : invocations) {
            if (suspicious[inv[1]] && !suspicious[inv[0]]) {
                canRemove = false;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (!canRemove) {
            for (int i = 0; i < n; i++) result.add(i);
        } else {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) result.add(i);
            }
        }
        return result;
    }
}
