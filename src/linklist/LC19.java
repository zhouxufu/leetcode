package linklist;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1340 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


class ListNode {
 int val;
 ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode prev = new ListNode(-1,head);
        ListNode p1 = prev;
        for (int i = 0; i < n; i++) {
            if(p1 == null){
                return head;
            }
            p1=p1.next;
        }
        ListNode p2 = prev;
        while (p1.next != null ) {
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return prev.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
