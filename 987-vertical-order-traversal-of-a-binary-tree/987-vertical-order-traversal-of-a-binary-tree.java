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
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         //从左到右，从上到下需要保存每一个node的col，level，val
//         //key:col value:the node which have same col, int[]A A[0]:level A[1]:val
//         //The order matters, so we use TreeMap
// //         DFS + 哈希表 + 排序
// // 根据题意，我们需要按照优先级「“列号从小到大”，对于同列节点，“行号从小到大”，对于同列同行元素，“节点值从小到大”」进行答案构造。

//         Map<Integer, List<int[]>> map = new TreeMap<>();
//         List<List<Integer>> res = new LinkedList<>();
//         dfs(root, 0, map, 0);
//         for (List<int[]> temp : map.values()) {
//             //for same col, we sort by level, if same level and same col, sort by value
//             Collections.sort(temp, (a, b) -> {
//                 if (a[0] != b[0]) {
//                     return a[0] - b[0];
//                 } else {
//                     return a[1] - b[1];
//                 }
//             });
//             List<Integer> cur = new LinkedList<>();
//             for (int[] A : temp) {
//                 cur.add(A[1]);
//             }
//             res.add(cur);
//         }
//         return res;
//     }
    
//     private void dfs(TreeNode root, int level, Map<Integer, List<int[]>> map, int col) {
//         if (root == null) {
//             return;
//         }
//         if (!map.containsKey(col)) {
//             map.put(col, new LinkedList<int[]>());
//         }
//         map.get(col).add(new int[] {level, root.val});
//         dfs(root.left, level + 1, map, col - 1);
//         dfs(root.right, level + 1, map, col + 1);
//     }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // make sure on each level, the node is sorted by value
        //example3,6比5先进q，但是要先弹出5在弹出6，所以要用pq，里面根据值来比较
        PriorityQueue<VerticalNode> pq = new PriorityQueue<>();
         // key is col
        Map<Integer, List<Integer>> map = new TreeMap<>();
        pq.offer(new VerticalNode(root, 0, 0));
        while (!pq.isEmpty()) {
            VerticalNode cur = pq.poll();
            map.putIfAbsent(cur.col, new ArrayList<>());
            map.get(cur.col).add(cur.node.val);
            if (cur.node.left != null) {
                pq.offer(new VerticalNode(cur.node.left, cur.row + 1, cur.col - 1));
            }
            if (cur.node.right != null) {
                pq.offer(new VerticalNode(cur.node.right, cur.row + 1, cur.col + 1));
            }
        }
        for (List<Integer> list : map.values()) {
            res.add(list);
        }
        return res;
    }
    
    class VerticalNode implements Comparable<VerticalNode> {
        TreeNode node;
        int row;
        int col;
        public VerticalNode(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
        
        @Override
        public int compareTo(VerticalNode v1) {
            if (this.row == v1.row) {
                return this.node.val - v1.node.val;
            } else {
                return this.row - v1.row;
            }
        }
    }
}
