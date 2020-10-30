public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
	    ListNode p = head;
	    while (p != null) {
	        p = p.next;
	        n++;
	    }
	    list = head;
	    return sortListHelper(0, n - 1);
    }
    private TreeNode sortListHelper(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        
        TreeNode leftChild = sortedListHelper(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        
        parent.left = leftChild;
        list = list.next;
        
        TreeNode rightChild = sortedListHelper(mid + 1, end);
        parent.right = rightChild;
        
        return parent;
    }
}