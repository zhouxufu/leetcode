package 剑指offer;

public class Offer03 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        final int repeatNumber = solution.findRepeatNumber(arr);

    }


    static class Solution {
        public int findRepeatNumber(int[] nums) {
            int cur = 0;
            while (true) {
                if (cur==nums[cur]) {
                    cur++;
                    continue;
                }
                int i = nums[cur];
                int j = nums[i];
                if(i == j){
                    return i;
                }
                swap(nums,cur,i);
            }
        }

        private void swap(int[] nums, int cur, int i) {
            int temp = nums[cur];
            nums[cur] = nums[i];
            nums[i]=temp;
        }
    }
}



