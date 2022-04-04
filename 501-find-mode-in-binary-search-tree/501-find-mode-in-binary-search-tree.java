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
    Integer prev = null;
    int cnt = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new LinkedList<>();
        traverse(root, modes);
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = modes.get(i);
        }
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> modes) {
        if (root == null) {
            return;
        }
        traverse(root.left, modes);
        if (prev != null) {
            if (prev == root.val) {
                cnt++;
            } else {
                cnt = 1;
            }
        }
        if (cnt > max) {
            max = cnt;
            modes.clear();
            modes.add(root.val);
        } else if (cnt == max) {
            modes.add(root.val);
        }
        prev = root.val;
        traverse(root.right, modes);
    }
}