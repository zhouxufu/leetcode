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
        for (int i = 0; i < arr.length; i++) {
            int insertNode ;
            int j;
            for (j = i,insertNode = arr[i]; j > 0 && arr[j-1] > insertNode; j--) {
                arr[j]=arr[j-1];
            }
            arr[j]=insertNode;
        }

    }

}
