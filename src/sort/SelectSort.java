package sort;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 2, 4, 3};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int pos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[pos] > arr[j]) {
                    pos = j;
                }
            }
            if (i != pos) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
            }
        }
    }


    public static void sort(int[] arr) {
        if (arr==null||arr.length<2) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int pos = i;
            for (int j = 0; j <arr.length; j++) {
                if(arr[pos]>arr[j]){
                    pos=j;
                }
            }
            if(pos!=i){
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
            }
        }

    }


}
