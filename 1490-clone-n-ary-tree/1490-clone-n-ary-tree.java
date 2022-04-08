/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(root, map);
    }
    
    private Node dfs(Node cur, Map<Node, Node> map){
        if(cur == null) return null;
        if(map.containsKey(cur)) 
            return map.get(cur);
        
        map.put(cur, new Node(cur.val));
        
        for(Node next : cur.children){
            map.get(cur).children.add(dfs(next, map));
        }
        
        return map.get(cur);
    }
}