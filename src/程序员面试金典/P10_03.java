package 程序员面试金典;

public class P10_03 {

    static class Solution {
        public int search(int[] arr, int target) {
            int left = 0;
            int right = arr.length-1;
            int res = -1;

            while (left < right) {
                int mid = left +  ( right - left) / 2;
                //升序区间段
                if (arr[mid] < arr[left] && arr[mid] < arr[right]) {
                    if(arr[mid]<target){
                        left =mid +1;
                    }else{
                        if(arr[mid]==target){
                            return mid;
                        }
                        right = left-1;
                    }
                }else if (arr[mid] > arr[left] && arr[mid] > arr[right]) {
                    if(arr[mid]>target){
                        right =mid-1;
                    }else{
                        if(arr[mid]==target){
                            return mid;
                        }
                        left = mid+1;
                    }
                }else{
                    if(arr[left] == target){
                        return left;
                    }
                    left++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr ={1,1,1,1,1,2,1,1,1};
        final int search = s.search(arr, 2);
        System.out.println(search);
    }
}
