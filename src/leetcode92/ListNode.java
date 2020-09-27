package leetcode92;

/**
 * @author codeZzz
 * @date 2020/9/27
 */
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummay = new ListNode(-1);
        dummay.next = head;
        printListNode(dummay);

        ListNode ahead=dummay, prev = null, current = null, next = null;
        for (int i = 1; i < m; i++) {
            ahead = ahead.next;
        }
        prev=ahead.next;
        current = prev.next;
        for (int i = 0; (i < n - m) && current != null; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ahead.next.next=current;
        ahead.next=prev;

        printListNode(dummay);

        return dummay.next;
    }

    private void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val+",");
            listNode=listNode.next;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode next = null;
        for (int i = 5; i > 0; i--) {
            ListNode listNode = new ListNode(i);
            listNode.next = next;
            next = listNode;
        }
        solution.reverseBetween(next, 2, 4);
    }
}


