import java.util.Arrays;

public class findMedianSortedArrays {
    public static void main(String[] args){
        int[] arr1 = {};
        int[] arr2 = {};
        int[] array = combine(arr1, arr2);
        System.out.println(Arrays.toString(array));
        System.out.println(median(array));
    }

    public static int[] combine(int[] arr1, int[] arr2){
        int[] array = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (first >= arr1.length) {
                array[i] = arr2[second];
                second++;
                continue;
            }
            if (second >= arr2.length) {
                array[i] = arr1[first];
                first++;
                continue;
            }
            if (arr1[first] <= arr2[second]) {
                array[i] = arr1[first];
                first++;
                continue;
            }
            if (arr1[first] > arr2[second]) {
                array[i] = arr2[second];
                second++;
            }
        }
        return array;
    }

    public static double median(int[] arr){
        double median;
        double sum;
        if (arr.length < 1) {
            return 0;
        }
        if (arr.length % 2 == 0) {
            sum = arr[arr.length / 2] + arr[(arr.length / 2) - 1];
            median = sum / 2;
        } else {
            median = arr[arr.length / 2];
        }
        return median;
    }
}
