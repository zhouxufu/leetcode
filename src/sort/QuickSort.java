package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        Random random = new Random();
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        doSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void doSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int part = arr[start];
        int left = start;
        int right = end;
        while (left >= right) {
            while (left >= right && arr[left] < part) {
                left++;
            }
            while (left >= right && arr[right] > part) {
                right--;
            }
            if(left<right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left]=temp;
                left++;
                right--;
            }
        }
        doSort(arr,start,right);
        doSort(arr,left,end);

    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        sort(arr, start, right);
        sort(arr, left, end);
    }

}
