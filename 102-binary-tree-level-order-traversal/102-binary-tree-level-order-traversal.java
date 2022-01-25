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
    /*
        //bfs
        3     size to guarantee we can record each level information
      9   20
         15  7
        queue:15 7               initial:3
        list:{{3}, {9, 20}, }    generate rule: left and right child is not null
                                 teminate: queue is empty
    */
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new LinkedList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> curList = new LinkedList<>();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode cur = queue.poll();
    //             curList.add(cur.val);
    //             if (cur.left != null) {
    //                 queue.offer(cur.left);
    //             }
    //             if (cur.right != null) {
    //                 queue.offer(cur.right);
    //             }
    //         }
    //         res.add(curList);
    //     }
    //     return res;
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        //打印出来的结果和遍历顺序无关
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}