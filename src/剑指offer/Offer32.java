package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Offer32 {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> list = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            list.offer(root);
            while (!list.isEmpty()) {
                TreeNode treeNode = list.poll();
                result.add(treeNode.val);
                if (treeNode.left != null) {
                    list.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.offer(treeNode.right);
                }
            }

            return result.stream().mapToInt(Integer::valueOf).toArray();
        }


    }

    static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int  i = 0;
            res.add(new ArrayList<>());
            while(!queue.isEmpty()){
                while(queue.peek().left!=null){
                    queue.push(queue.peek().left);
                    i++;
                    res.add(new ArrayList<>());
                }
                TreeNode pop = queue.pop();
                if(pop.right != null){
                    List<Integer> integers = res.get(i + 1);
                    if(integers==null){
                        integers = new ArrayList<>();
                        res.add(integers);
                    }
                    integers.add(pop.right.val);
                }
            }
            return res;
        }





    }

    public static void main(String[] args) {

//        TreeNode t01 = new TreeNode(1);
//        TreeNode t02 = new TreeNode(2);
//        TreeNode t03 = new TreeNode(3);
//        TreeNode t04 = new TreeNode(4);
//        TreeNode t05 = new TreeNode(5);
//        TreeNode t06 = new TreeNode(6);
//
//        t01.left = t02;
//        t01.right = t03;
//
//        t02.left= t04;
//        t02.right= t05;
//
//        t03.left=t06;
//
//
//
//
//        Solution2 solution2 = new Solution2();
//        final List<Integer> integers = solution2.levelOrder2(t01);
//
//        System.out.println(integers);

        Solution3 solution3 = new Solution3();
        int[] a1= {1,2,3,0,0,0};
        int[] a2= {2,5,6};
        solution3.merge(a1,3,a2,3);
    }

    static class Solution3 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] arr = new int[m+n];
            int i = 0;
            int j = 0;
            for(int a=0;a<m+n;a++){
                if(i<m && j<n) {
                    if (nums1[i] > nums2[j]) {
                        arr[a] = nums2[j];
                        j++;
                    }else if(nums1[i] < nums2[j]){
                        arr[a] = nums1[i] ;
                        i++;
                    }else{
                        arr[a] =nums1[i];
                        a++;
                        arr[a] =nums2[j];
                        j++;
                        i++;
                    }
                }else if(i<m){
                    arr[a] =nums1[i];
                    i++;
                }else if(j<n){
                    arr[a] =nums2[i];
                    j++;
                }
            }
            for(int a = 0;a<nums1.length;a++){
                nums1[a]=arr[a];
            }
        }
    }
}
