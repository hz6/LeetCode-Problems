public class ListHasCycle {
	public boolean solution(ListNode head) {
		if (head == null) return false;
        ListNode node1 = head, node2 = head.next;
        while (node1!=null && node2!=null && node2.next!=null) {
            if (node1 == node2) {
                return true;
            }
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return false;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}