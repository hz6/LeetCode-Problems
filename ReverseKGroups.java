/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseKGroups {

	public ListNode reverseByStack(ListNode head, int k) { // space O(n)
		if (head == null) return null;
		Stack<ListNode> stack = new Stack<>();
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		ListNode next = dummy.next;
		while (next != null) {
		    for (int i = 0; i < k && next != null; i ++) {
		        stack.push(next);
		        next = next.next;
		    }
		    
		    if (stack.size() != k) return dummy.next;
		    while (stack.size() != 0) {
		        current.next = stack.pop();
		        current = current.next;
		    }
		    current.next = next;
		}
		return dummy.next;
	}

	public ListNode reverseInPlace(ListNode head, int k) { // space O(1)
		if (head == null) return null;

	}
}