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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        //deque because we can have accss the front and back
        //head        tail
        //4 5 6 when we pop 4, we find target, and return the head of deque
        //upper level 2 3 we offer from end
        //when finf 4
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        while (!dq.isEmpty()) {
            //level order traversal
            int size = dq.size();
            for (int i = 0; i < size; i++) {
               TreeNode cur = dq.pollFirst();
                if (cur == u) {
                    if (i == size - 1) {
                        return null;
                    } else {
                        return dq.peekFirst();
                    }
                }
                if (cur.left != null) {
                    dq.offerLast(cur.left);    
                }
                if (cur.right != null) {
                    dq.offerLast(cur.right);    
                }
            }
        }
        return null;
    }
}