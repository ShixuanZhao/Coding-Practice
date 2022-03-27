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
        high level: bfs
        data structure: deque
        initial state: push root
        deque: 15 7  
        res:(3) (20, 9)
        for the odd level: pop from first end, and push left node first and then right node to last end 
        for the even level: pop from last end, and push right node first and then left node to first end
        termination: the queue is empty
    */
    /*
    odd:pop from left
    push left node and then right node into right side
    
    even:pop from right
    push right node and then left node intp left side
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (isOdd) {
                    TreeNode temp = queue.pollFirst();
                    cur.add(temp.val);
                    if (temp.left != null) {
                        queue.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offerLast(temp.right);
                    }
                } else {
                    TreeNode temp = queue.pollLast();
                    cur.add(temp.val);
                    if (temp.right != null) {
                        queue.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        queue.offerFirst(temp.left);
                    }
                }
            }
            isOdd = !isOdd;
            res.add(cur);
        }
        return res;
    }
}