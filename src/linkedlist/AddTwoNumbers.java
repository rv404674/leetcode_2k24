package linkedlist;

class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tempHead = head;
        int carry = 0;
        int left = 0;

        while (l1 != null || l2 != null) {

            int l1Num;
            if (l1 != null) {
                l1Num = l1.val;
                l1 = l1.next;
            } else {
                l1Num = 0;
            }

            int l2Num;
            if (l2 != null) {
                l2Num = l2.val;
                l2 = l2.next;
            } else {
                l2Num = 0;
            }

            int curNum = carry + l1Num + l2Num;
            carry = curNum / 10;
            left = curNum % 10;

            tempHead.next = new ListNode(left, null);
            tempHead = tempHead.next;
        }

        if (carry != 0) {
            tempHead.next = new ListNode(carry, null);
        }


        return head.next;
    }
}

public class AddTwoNumbers {
}
