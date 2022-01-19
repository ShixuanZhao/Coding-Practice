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
    // public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    //     if (root1 == null || root2 == null) {
    //         return false;
    //     }
    //     int sum = root1.val + root2.val;
    //     if (sum == target) {
    //         return true;
    //     } else if (sum < target) {
    //         return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    //     } else {
    //         return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
    //     }
    // }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        Set<Integer> set = new HashSet();
        add(root1, set);
        return find(root2, set, target);
    }
    
    private void add(TreeNode root, Set<Integer> set) {
        if(root == null) return;
        set.add(root.val);
        add(root.left, set);
        add(root.right, set);
    }
    
    private boolean find(TreeNode root, Set<Integer> set, int target) {
        if(root == null) return false;
        if(set.contains(target - root.val)) return true;
        return find(root.left, set, target) || find(root.right, set, target);
    }
}