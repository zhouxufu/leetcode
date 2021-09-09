package 剑指offer;

public class Offer11 {

    public static void main(String[] args) {
        int[] arr = {3,3,1,3};
        Solution solution = new Solution();
        final int i = solution.minArray(arr);
        System.out.println(i);
    }


    static class Solution {
        public int minArray(int[] numbers) {
            if(numbers==null || numbers.length < 1){
                return -1;
            }
            if(numbers.length == 1){
                return numbers[0];
            }
            int start = 0;
            int end = numbers.length-1;
            if(numbers[end] > numbers[start]){
                return numbers[start];
            }
            while(end-start>1){
                int middle = start+(end-start)/2;
                if(numbers[middle]>numbers[end]){
                    start= middle;
                }else{
                    end = middle;
                }
            }
            return numbers[start]>numbers[end]?numbers[end]:numbers[start];
        }
    }
}
