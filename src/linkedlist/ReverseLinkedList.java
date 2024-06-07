package linkedlist;

// Striver
// Understand his way in depth build the intuition.
// Striver - https://www.youtube.com/watch?v=D2vI2DNJGd8

// 1       -> 2     -> 4
// prev     current    front

//
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode front = head;

        while (cur != null) {
            front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }

        return prev;
    }
}
