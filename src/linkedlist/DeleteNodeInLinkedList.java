package linkedlist;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;

        nextNode.next = null;
    }
}
