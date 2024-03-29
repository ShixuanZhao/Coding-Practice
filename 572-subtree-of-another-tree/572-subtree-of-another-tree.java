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
    //check each root of subtree, whether it is the same as subRoot tree
    //O(n^2)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    
// public boolean isSubtree(TreeNode s, TreeNode t) {
//     Queue<TreeNode> nodes = new ArrayDeque<>();
//     nodes.offer(s);
//     while (!nodes.isEmpty()) {
//         TreeNode node = nodes.poll();
//         if (isSameTree(node, t)) {
//             return true;
//         }
//         if (node.left != null) {
//             nodes.offer(node.left);
//         }
//         if (node.right != null) {
//             nodes.offer(node.right);
//         }
//     }
//     return false;
// }

// public boolean isSameTree(TreeNode s, TreeNode t) {
//     if (s == null && t == null) {
//         return true;
//     }
//     if (s == null || t == null) {
//         return false;
//     }
//     if (s.val != t.val) {
//         return false;
//     } else {
//         return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
//     }
// }
    
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String s1 = getString(root);
//         String s2 = getString(subRoot);
//         return s1.indexOf(s2) == -1 ? false : true;
//     }
    
//     //corner case: 12 2 return false
//     private String getString(TreeNode root) {
//         if (root == null) {
//             return "#";
//         }
//         StringBuilder sb = new StringBuilder();
        
//         sb.append("(");
//         sb.append(root.val);
//         sb.append(")");
        
//         sb.append("(");
//         sb.append(getString(root.left));
//         sb.append(")");
        
//         sb.append("(");
//         sb.append(getString(root.right));
//         sb.append(")");
//         return sb.toString();
//     }
}