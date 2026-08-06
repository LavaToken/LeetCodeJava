import java.util.Arrays;

public class construct2DArray {
    public static void main(String[] args){
        int[] first = {1, 2, 3, 4};
        int[][] array = construct2DArray(first, 2, 2);
        System.out.println(Arrays.toString(array[0]) + ", " + Arrays.toString(array[1]));

        int[] second = {1, 2, 3};
        int[][] array2 = construct2DArray(second, 1, 3);
        System.out.println(Arrays.toString(array2[0]));

//        int[][] ans = new int[2][2];
//        ans[0][0] = 1;
//        ans[0][1] = 2;
//        ans[1][0] = 3;
//        ans[1][1] = 4;
//        System.out.println(Arrays.toString(ans[0]));
//        System.out.println(Arrays.toString(ans[1]));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                ans[i][j] = original[count];
                count++;
            }
        }
        return ans;
    }

}
