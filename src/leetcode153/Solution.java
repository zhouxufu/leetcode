package leetcode153;//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 274 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        //3,4,5,1,2
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int midden = (right - left) / 2 + left;
            if (nums[midden] > nums[right]) {
                left = midden + 1;
                continue;
            }
            if (nums[midden] < nums[right]) {
                right = midden ;
                continue;
            }
            if (nums[midden]==nums[right]) {
                return nums[midden];
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        Solution solution = new Solution();
        int min = solution.findMin(arr);
        System.out.println(min);
    }
}



//leetcode submit region end(Prohibit modification and deletion)
