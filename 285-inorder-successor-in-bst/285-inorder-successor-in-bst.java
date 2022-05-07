/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//         TreeNode[] res = new TreeNode[1];
//         inOrder(root, p, res);
//         return res[0];
//     }
    
//     private void inOrder(TreeNode root, TreeNode p, TreeNode[] res) {
//         if (root == null) {
//             return;
//         }
//         inOrder(root.left, p, res);
//         if (root.val > p.val) {
//             res[0] = root;
//             return;
//         }
//         inOrder(root.right, p, res);
//     }
    
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] res = new TreeNode[1];
        int[] cnt = new int[1];
        inOrder(root, p, res, cnt);
        return res[0];
    }
    
    private void inOrder(TreeNode root, TreeNode p, TreeNode[] res, int[] cnt) {
        if (root == null) {
            return;
        }
        inOrder(root.left, p, res, cnt);
        if (cnt[0] == 0 && root.val > p.val) {
            res[0] = root;
            cnt[0]++;
        }
        inOrder(root.right, p, res, cnt);
    }
    
    //like binary search
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//     TreeNode succ = null;
//     while (root != null) {
//         if (p.val < root.val) {
//             succ = root;
//             root = root.left;
//         }
//         else
//             root = root.right;
//     }
//     return succ;
// }

}


// public  TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
//     	if(root == null || p == null){return null;}
    	
//     	TreeNode predecessor = null;
//     	while(root != null){
//     		if(p.val <= root.val){
//     			root = root.left;
//     		}else{
//     			predecessor = root;
//     			root = root.right;
//     		}
//     	}
//     	return predecessor;
//     }