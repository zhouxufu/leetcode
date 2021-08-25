package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡
 */
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


//    public static void main(String[] args) {
//
//        Random random = new Random();
//        int[] arr = new int[10];
//        for (int i = 0; i < 10; i++) {
//            arr[i] = random.nextInt(1000);
//        }
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//    }

    private static void sort(int[] arr) {
        if(arr==null||arr.length<2){
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
         double sqrt = Math.sqrt(Math.abs(Math.pow(2 - 1, 2) + Math.pow(2 - 1, 2)));
         double sqrt2 = Math.sqrt(Math.abs(Math.pow(7 - 2, 2) + Math.pow(7 - 2, 2)));
         double sqrt3 = Math.sqrt(Math.abs(Math.pow(7 - 1, 2) + Math.pow(7 - 1, 2)));
        System.out.println(sqrt2);
        System.out.println(sqrt);
        System.out.println(sqrt3);
    }
}
