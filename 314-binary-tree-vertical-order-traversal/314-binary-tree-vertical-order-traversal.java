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
    //T = O(nlogn) because we need to sorting in the for loop
    // public List<List<Integer>> verticalOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     //col to a list of ele which have diff level and val, so we need a int[] to record the level and val for each node
    //     //key:col value:the node which have same col, int[]A A[0]:level A[1]:val
    //     Map<Integer, List<int[]>> map = new TreeMap<>();
    //     dfs(root, map, 0, 0);
    //     for (List<int[]> cur : map.values()) {
    //         //sort by level
    //         //because dfs we use preOrder which can ensure traverse left node first when same col and level
    //         Collections.sort(cur, (a, b) -> (a[0] - b[0]));
    //         List<Integer> temp = new ArrayList<>();
    //         for (int[] arr : cur) {
    //             temp.add(arr[1]);
    //         }
    //         res.add(temp);
    //     }
    //     return res;
    // }
    // //for the treemap, key is col, value is a pair<level, val>
    // private void dfs(TreeNode root, Map<Integer, List<int[]>> map, int col, int level) {
    //     if (root == null) {
    //         return;
    //     }
    //     if (!map.containsKey(col)) {
    //         map.put(col, new LinkedList<int[]>());
    //     }
    //     map.get(col).add(new int[] {level, root.val});
    //     //preOrder traversal, must be traverse left subtree first because for same level and col, we need the left one first 
    //     dfs(root.left, map, col - 1, level + 1);
    //     dfs(root.right, map, col + 1, level + 1);
    // }
    
    //better solution T = O(n) S = O(n)
    //BFS, we do not sorting for each col
    //BFS is ok because If two nodes are in the same row and column, the order should be from left to right.
    /*
    BFS
    <col, List<Integer>> map 
    <TreeNode, Integer> colMap record node to col, 
    BFS
    q:3 colMap(3, 0)
    expand 3, and update the map
    generate: 9, 8 update colMap
    for 9 (9, -1)
    for 8 (8, 1)
    go through map, get res
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        Map<TreeNode, Integer> colMap = new HashMap<>();
        int minCol = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        colMap.put(root, 0);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int col = colMap.get(cur);
            resMap.putIfAbsent(col, new ArrayList<>());
            resMap.get(col).add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
                colMap.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                colMap.put(cur.right, col + 1);
            }
            minCol = Math.min(minCol, col);
        }
        while (resMap.containsKey(minCol)) {
            res.add(resMap.get(minCol));
            minCol++;
        }
        return res;
        
    }
}