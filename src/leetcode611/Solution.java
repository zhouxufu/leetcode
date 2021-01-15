package leetcode611;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int third = nums.length - 1;
        int count = 0;

        while (third >= 2) {
            int left = 0;
            int right = third - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[third]) {
                    count += right - left;
                    right--;

                } else {
                    left += 1;
                }
                if (right==left) {
                    third--;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3,4,5,6};
        int i = solution.triangleNumber(arr);
        System.out.println(i);

    }
}