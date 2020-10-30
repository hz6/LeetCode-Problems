/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
public class CloneGraph{

	// DFS method
	public Node clone(Node node) {
        if (node == null)
            return null;
        map = new HashMap<>();
        return dfs(node);
	}

	private Node dfs(Node node) {
        if (map.containsKey(node))
            return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for (Node n : node.neighbors) {
            copyNode.neighbors.add(dfs(n));
        }
        return copyNode;		
	}

	// BFS method
	public Node clone(Node node) {
		if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node nodeCopy = new Node(node.val);
        map.put(node, nodeCopy);
        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            for (Node n : vertex.neighbors) {
                if (map.containsKey(n)) {
                    map.get(vertex).neighbors.add(map.get(n));
                } else {
                    Node neighborCopy = new Node(n.val);
                    map.get(vertex).neighbors.add(neighborCopy);
                    map.put(n, neighborCopy);
                    queue.add(n);
                }
            }
        }
        return nodeCopy;
	}
}