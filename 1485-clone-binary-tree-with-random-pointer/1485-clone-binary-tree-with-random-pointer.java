/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
     public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node,NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }
    
    public NodeCopy dfs(Node root, Map<Node,NodeCopy> map){
        if (root==null) return null;        
        
        if (map.containsKey(root)) return map.get(root);
        
        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root,newNode);
        
        newNode.left=dfs(root.left,map);
        newNode.right=dfs(root.right,map);
        newNode.random=dfs(root.random,map);
        
        return newNode;
        
    }
}