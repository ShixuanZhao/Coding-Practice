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
/*
    1
  2   3
  print:213
  stack:
*/
class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
       stack = new ArrayDeque<>();
       pushAllLeft(root);
    }
    
    public int next() {
        TreeNode cur = stack.pollFirst();
        pushAllLeft(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    //from root, keep pushing all the left node into stack
    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */