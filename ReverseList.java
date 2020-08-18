public class ReverseList {
  public ListNode reverseIterate(ListNode head) {
    ListNode prev = null; // first node is last --> next node is null
    ListNode curr = head; // start traversal/iteration
    while (curr != null) {
      ListNode tNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tNext;
    }
    return prev;
  }

  public ListNode reverseRecurrsion(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode rlh = reverseRecurrsion(head.next);
    (head.next).next = head;
    head.next = null;
    return rlh;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int x) {
    this.val = x;
  }

  ListNode(int x, ListNode next) {
    this.val = x;
    this.next = next;
  }
}