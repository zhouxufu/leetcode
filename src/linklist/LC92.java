package linklist;

import java.util.List;

public class LC92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }
            ListNode dummy =  new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            for (int i = 0; i < left-1; i++) {
               pre=  pre.next;
            }

            ListNode leftNode =pre.next;

            ListNode rightNode = leftNode;
            for (int i = 0; i <right-left ; i++) {
                rightNode = rightNode.next;
            }

            ListNode lastNode = rightNode.next;

            rightNode.next = null;
            pre.next = null;

            reverse(leftNode);

            pre.next = rightNode;
            leftNode.next =lastNode;
            return dummy.next;
        }

        private void reverse(ListNode leftNode) {
            ListNode next = leftNode.next;
            while(next!=null){
               ListNode temp =  next.next;
               next.next = leftNode;
               leftNode = next;
               next = temp;
            }
        }
    }

}
