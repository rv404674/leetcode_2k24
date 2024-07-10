package linkedlist;


// NOTE: This is the optimal solution everywhere.
// Not exactly O(1) though

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;


        int k = 1;

        while (head != null) {
            if (k % 2 != 0) {
                // odd
                oddTail.next = head;
                oddTail = head;
            } else {
                evenTail.next = head;
                evenTail = head;
            }

            k++;
            head = head.next;
        }

        evenTail.next = null;
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}


public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        System.out.println(solution.oddEvenList(head));
    }


}
