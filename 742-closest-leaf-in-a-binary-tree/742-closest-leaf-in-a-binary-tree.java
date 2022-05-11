/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
       private static TreeNode targetNode;
    private static int k;
    
    public int findClosestLeaf(TreeNode root, int k) {
        targetNode = null;
        this.k = k;
        
        /* Map child node to parent node. */
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        buildParentMap(root, childToParent);
        
        /* BFS to get closest leaf. */
        Deque<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(targetNode);
        visited.add(targetNode.val);
        
        while (!queue.isEmpty()) {          
            TreeNode curr = queue.poll();
            
            /* Check if current polled treenode is a leaf. */
            if (curr.left == null && curr.right == null)
                return curr.val;
            
            /* Add current node's children to queue. */
            if (curr.left != null && !visited.contains(curr.left.val)) {
                visited.add(curr.left.val);
                queue.offer(curr.left);
            }
            if (curr.right != null && !visited.contains(curr.right.val)) {
                visited.add(curr.right.val);
                queue.offer(curr.right);
            }
            
            /* Add current node's parent to queue. */
            TreeNode parent = childToParent.get(curr);
            if (parent != null && !visited.contains(parent.val)) {
                visited.add(parent.val);
                queue.offer(parent);                
            }                
        }
        
        return -1;
    }
    
    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> childToParent) {
        if (root == null)
            return;
        
        buildParentMap(root.left, childToParent);
        buildParentMap(root.right, childToParent);
        
        /* Check if current root is the target node. */
        if (root.val == k)
            targetNode = root;
        
        if (root.left != null)
            childToParent.put(root.left, root);
        if (root.right != null)
            childToParent.put(root.right, root);
    }
}