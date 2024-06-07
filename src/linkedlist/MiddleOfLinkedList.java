package linkedlist;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
