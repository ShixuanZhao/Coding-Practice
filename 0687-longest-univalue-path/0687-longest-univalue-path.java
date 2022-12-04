class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }
    
    //return path length that across root
    //for each root, return the number of node which val == root(one side)
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = root.left != null && root.left.val == root.val ? left : 0;
        right = root.right != null && root.right.val == root.val ? right : 0;
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}