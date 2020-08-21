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
public class MergeKSortedList {
    
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

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.isEmpty()) return null;
        int end = lists.size() - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
                begin++;
                end--;
            }
        }
        return lists.get(0);
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }
}