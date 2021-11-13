package leetcode144;

import 剑指offer.Offer32;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7);

        Integer a = list.stream().findAny().get();
        a = list.stream().findAny().get();
        a = list.stream().findAny().get();
        a = list.stream().findAny().get();
        a = list.stream().findAny().get();
        a = list.stream().findAny().get();
        System.out.println(
                a
        );
//        LocalDate now = LocalDate.now();
//        LocalDate localDate = now.minusDays(1);
//         int i = now.getDayOfYear() - localDate.getDayOfYear();
//        System.out.println(i);
//        Integer certifyState =2 ;
//        final boolean equals = Objects.equals(2, certifyState);
//        String s = LocalDateTime.now().toString();
//        System.out.println(equals);
//        final long l = System.currentTimeMillis();
//        System.out.println(l);
//        TreeNode treeNode  =new TreeNode(1);
//        TreeNode treeNode2  =new TreeNode(2);
//        TreeNode treeNode3  =new TreeNode(3);
//        treeNode.right=treeNode2;
//        treeNode2.left=treeNode3;
//
//        Solution solution=  new Solution();
//        final List<Integer> integers = solution.preorderTraversal(treeNode);

//        Map<String,String> data = new HashMap<>();
//        data.put("1","1");
//        data.put("2","2");
//        data.put("3","3");
//        Set<String> strings = data.keySet();
//        strings.clear();
//        System.out.println(data);
//        String str = "6.888";
//
//         BigDecimal bigDecimal = new BigDecimal(str);
//            bigDecimal = bigDecimal.setScale(7, RoundingMode.HALF_UP);
//
//
//        System.out.println(bigDecimal.toString());
//        System.out.println(bigDecimal.toPlainString());

//        Boolean b  = null;
//        Object c = null;
//        Boolean d = false;
//
//         boolean b1 = b instanceof Boolean;
//        final boolean b2 = c instanceof Boolean;
//        final boolean b3 = d instanceof Boolean;

//         int i = Integer.parseInt(null);
//        System.out.println(i);


    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


}