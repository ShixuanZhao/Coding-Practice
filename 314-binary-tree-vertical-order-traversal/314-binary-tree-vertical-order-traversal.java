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
        List<List<Integer>> res = new ArrayList<>();
        //col to a list of ele which have diff level and val, so we need a int[] to record the level and val for each node
        Map<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        for (List<int[]> cur : map.values()) {
            //sort by level
            Collections.sort(cur, (a, b) -> (a[0] - b[0]));
            List<Integer> temp = new ArrayList<>();
            for (int[] arr : cur) {
                temp.add(arr[1]);
            }
            res.add(temp);
        }
        return res;
    }
    
    private void dfs(TreeNode root, Map<Integer, List<int[]>> map, int col, int level) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(col)) {
            map.put(col, new LinkedList<int[]>());
        }
        map.get(col).add(new int[] {level, root.val});
        dfs(root.left, map, col - 1, level + 1);
        dfs(root.right, map, col + 1, level + 1);
    }
}