package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class LC102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            //   1
            // 2  3
            //4 5 6 7
            List<List<Integer>> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                List<Integer> integers = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    integers.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                result.add(integers);
            }

            return result;
        }
    }
}