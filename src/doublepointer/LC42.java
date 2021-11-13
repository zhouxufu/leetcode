package doublepointer;

public class LC42 {
    static class Solution {
        public int trap(int[] height) {
            if (height == null || height.length < 2) {
                return 0;
            }

            int left = 0;
            int right = height.length - 1;
            int minHeight = Math.min(height[left], height[right]);
            int water = 0;

            while (left < right) {

                if (height[left] <= height[right]) {
                    int temp = minHeight - height[left];
                    water += Math.max(temp, 0);
                    left++;
                    minHeight = Math.min(Math.max(height[left], minHeight), height[right]);
                } else {
                    int temp = minHeight - height[right];
                    water += Math.max(temp, 0);
                    right--;
                    minHeight = Math.min(Math.max(height[right], minHeight), height[left]);
                }
            }
            return water;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4, 2, 0, 3, 2, 5};
        int trap = solution.trap(arr);
        System.out.println(trap);

    }
}