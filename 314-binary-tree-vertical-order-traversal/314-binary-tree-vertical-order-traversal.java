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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //从左到右，从上到下需要保存每一个node的col，level，val
        //key:col value:the node which have same col, int[]A A[0]:level A[1]:val
        //The order matters, so we use TreeMap
        Map<Integer, List<int[]>> map = new TreeMap<>();
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, 0, map, 0);
        for (List<int[]> temp : map.values()) {
            //for same col, we sort by level
            Collections.sort(temp, (a, b) -> (a[0] - b[0]));
            List<Integer> cur = new LinkedList<>();
            for (int[] A : temp) {
                cur.add(A[1]);
            }
            res.add(cur);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int level, Map<Integer, List<int[]>> map, int col) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(col)) {
            map.put(col, new LinkedList<int[]>());
        }
        map.get(col).add(new int[] {level, root.val});
        dfs(root.left, level + 1, map, col - 1);
        dfs(root.right, level + 1, map, col + 1);
    }
}