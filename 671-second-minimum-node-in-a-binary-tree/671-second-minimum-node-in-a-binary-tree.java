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
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.right==null || root.left==null) return -1;
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(root);
        //int second = Integer.MAX_VALUE is wrong, 因为corner case：第二小的就是Integer.MAX_VALUE
        //所以Integer null来处理这个corner case
        Integer second = null;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val != root.val) {
                if (second == null) {
                    second = cur.val;
                } else if (cur.val < second){
                    second = cur.val;
                    //no need to add it's children into queue
                    continue;
                }
            }
            if(cur.right!=null) q.offer(cur.right);
		    if(cur.left!=null) q.offer(cur.left);
        }
        return second == null ? -1 : second;
    }
}