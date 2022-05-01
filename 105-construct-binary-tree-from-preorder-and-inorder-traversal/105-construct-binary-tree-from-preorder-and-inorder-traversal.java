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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = buildMap(inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }
    
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, 
                              int inRight, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int size = indexMap.get(root.val) - inLeft;
        root.left = buildTree(preorder, preLeft + 1, preLeft + size, inorder, inLeft, inLeft + size - 1, indexMap);
        root.right = buildTree(preorder, preLeft + size + 1, preRight, inorder, inLeft + size + 1, inRight, indexMap);
        return root;
    }
    
    private Map<Integer, Integer> buildMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
}