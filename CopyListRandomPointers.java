public class CopyListRandomPointers {
    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-100);
        Node p = head;
        Node q = dummy;
        while ( p != null) {
            q.next = new Node(p.val);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null) {
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }

    public Node copyRandomList2(Node head) {
    	Node p = head;
        while (p != null) {
            Node next = p.next;
            Node cpy = new Node(p.val);
            p.next = cpy;
            cpy.next = next;
            p = next;
        }
        p = head;
        while (p != null) {
            p.next.random = (p.random != null) ? p.random.next : null;
            p = p.next.next;
        }
        p = head;
        Node headCpy = (p != null) ? p.next : null;
        while (p != null) {
            Node cpy = p.next;
            p.next = cpy.next;
            p = p.next;
            cpy.next = (p != null) ? p.next : null;
        }
        return headCpy;
    }
}