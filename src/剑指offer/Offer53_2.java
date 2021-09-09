package 剑指offer;

public class Offer53_2 {



   static class Solution {
        public int missingNumber(int[] nums) {
            return search(nums,0,nums.length-1);
        }

        public int search(int[] nums,int s,int e){
            int m = s+(e-s)/2;
            if(s >= e){
                if(nums[m]==m){
                    return -1;
                }else{
                    return m;
                }
            }
            if(nums[m]!=m){
                int result = search(nums,s,m-1);
                return result==-1? m:result;
            }else{
                return search(nums,m+1,e);
            }
        }
    }
}
