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
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1;
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
            level++;
        }
        return maxLevel;
    }
    
    //dfs
//     public int maxLevelSum(TreeNode root) {
//         int maxSum = Integer.MIN_VALUE;
//         int maxLevel = -1;
//         List<Integer> levelSum = new ArrayList<>();
//         dfs(root, levelSum, 0);
//         for (int i = 0; i < levelSum.size(); i++) {
//             if (levelSum.get(i) > maxSum) {
//                 maxSum = levelSum.get(i);
//                 maxLevel = i + 1;
//             }
//         }
//         return maxLevel;
//     }
    
//     private void dfs(TreeNode root, List<Integer> levelSum, int level) {
//         if (root == null) {
//             return;
//         }
//         if (levelSum.size() == level) {
//             levelSum.add(root.val);
//         } else {
//             levelSum.set(level, levelSum.get(level) + root.val);
//         }
//         dfs(root.left, levelSum, level + 1);
//         dfs(root.right, levelSum, level + 1);
//     }
}