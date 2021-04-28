package sort;

import java.util.Arrays;

/**
 * @author zhouxufu
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 2, 4, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int insertNode;
        int j;
        for (int i = 1; i < arr.length; i++) {
            for (j = i, insertNode = arr[j]; j > 0 && insertNode < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = insertNode;
        }
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int node;
        int j;
        for (int i = 1; i < arr.length; i++) {
            for (j = i, node = arr[j]; j > 0 && node < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = node;
        }
    }


}
