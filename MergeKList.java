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
class MergeKSortedList {
    
    private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode x, ListNode y) {
            return x.val - y.val;
        }
    };
     
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, listComparator);
        for (ListNode node:lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(-99);
        ListNode i = dummy;
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            i.next = n;
            i = i.next;
            if (n.next != null) {
                queue.add(n.next);
            }
        }
        return dummy.next;
    }
}