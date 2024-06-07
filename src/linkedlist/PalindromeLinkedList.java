package linkedlist;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // Approach - find Mid - using fast/slow approach
        // reverse from mid+1, end;
        // compare head, and newHead.
        ListNode mid = findMid(head);
        ListNode newHead = reverse(mid.next);

        while (newHead != null) {
            if (head.val != newHead.val)
                return false;

            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    public ListNode findMid(ListNode head) {
        // 1, 2, 2, 1
        // we want the mid to point to first 2.
        // in case of even length, check.
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
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
