package 剑指offer;

public class Offer35 {

    public static void main(String[] args) {
//        [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Solution s = new Solution();
        final Node node = s.copyRandomList(n1);
        System.out.println(node);

    }

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node point = head;
            while (point != null) {
                Node next = point.next;
                Node newNode = new Node(point.val);
                point.next = newNode;
                newNode.next = next;
                point = next;
            }
            point = head;
            while (point != null) {
                if (point.random != null) {
                    point.next.random = point.random.next;
                }

                point = point.next.next;
            }
            Node result = head.next;
            point = head;
            while (point != null) {
                Node next = point.next;
                point.next = next.next;
                if (point.next != null) {
                    next.next = point.next.next;
                }
                point = point.next;
            }
            return result;
        }
    }
}
