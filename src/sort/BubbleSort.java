package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp =arr[j + 1];
                    arr[j + 1]=arr[j];
                    arr[j]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(1000);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
