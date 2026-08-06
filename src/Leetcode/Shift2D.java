// 1260. Shift 2D Grid
// https://leetcode.com/problems/shift-2d-grid/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Shift2D {
    public static void main(String[] args){
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        List<List<Integer>> result = shiftGrid(grid, k);
        System.out.println(result); // [[9, 1, 2], [3, 4, 5], [6, 7, 8]]

        int[][] grid2 = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        System.out.println(shiftGrid(grid2, 4)); // [[12, 0, 21, 13], [3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10]]
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;

        int[][] finGrid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int x = (i * n + j + k) % total;
                finGrid[x / n][x % n] = grid[i][j];
            }
        }
        return Arrays.stream(finGrid).map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());

        // List<List<Integer>> finGrid = new ArrayList<>();
        // for(int i = 0; i < m; i++){
        //     List<Integer> row = new ArrayList<>();
        //     for(int j = 0; j < n; j++){
        //         row.add(0);
        //     }
        //     finGrid.add(row);
        // }

        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         int idx = (i * n + j + k) % total;
        //         finGrid.get(idx / n).set(idx % n, grid[i][j]);
        //     }
        // }
        // return finGrid;
    }
}
