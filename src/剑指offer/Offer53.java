package 剑指offer;

public class Offer53 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        Solution s = new Solution();

        final int search = s.search(arr, 8);

        System.out.println();
    }


    public static class Solution {
        public int search(int[] nums, int target) {
            if(nums==null){
                return 0;
            }
            int a = searchLeft(nums,0,nums.length-1,target);
            if(a==-1){
                return 0;
            }
            int b =  searchRight(nums,0,nums.length-1,target);
            return b-a+1;
        }

        public int searchLeft(int[] nums,int start,int end,int target){
            int middle = start + (end - start) /2;
            if(start >=end){
                return nums[middle] == target?middle:-1;
            }
            if(nums[middle] == target){
                int subLeft = searchLeft(nums,start,middle-1,target);
                return subLeft ==-1 ? middle:subLeft;
            }else if(nums[middle] > target){
                return searchLeft(nums,start,middle-1,target);
            }else{
                return searchLeft(nums,middle+1,end,target);
            }
        }

        public int searchRight(int[] nums,int start,int end,int target){
            int middle = start + (end - start) /2;
            if(start >=end){
               return nums[middle] == target?middle:-1;
            }
            if(nums[middle] == target){
                int subLeft = searchRight(nums,middle+1,end,target);
                return subLeft==-1?middle:subLeft;
            }else if(nums[middle] > target){
                return searchRight(nums,start,middle-1,target);
            }else{
                return searchRight(nums,middle+1,end,target);
            }
        }



    }
}


