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

class Solution {
    //dfs
//     public Node cloneGraph(Node node) {
//         Map<Node, Node> map = new HashMap<>();
//         return dfs(node, map);
//     }
    
//     private Node dfs(Node node, Map<Node, Node> map) {
//         if (node == null) {
//             return node;
//         }
//         if (!map.containsKey(node)) {
//             Node newNode = new Node(node.val);
//             map.put(node, newNode);
//             for (Node nei : node.neighbors) {
//                 newNode.neighbors.add(dfs(nei, map));
//             }
//         }
//         return map.get(node);
//     }
    
    //bfs
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    Node copied = new Node(nei.val);
                    map.put(nei, copied);
                    q.offer(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}