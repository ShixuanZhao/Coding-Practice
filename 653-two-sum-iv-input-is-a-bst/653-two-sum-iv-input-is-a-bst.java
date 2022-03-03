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
    public boolean findTarget(TreeNode root, int k) {
        //M1:把BST摊平之后双指针，T = O(n) S = O(n)
//         List<Integer> nums = new LinkedList<>();
//         inOrder(root, nums);
//         int i = 0; 
//         int j = nums.size() - 1;
//         //i < j not i <= j 自己和自己相加不算
//         while (i < j) {
//             if (nums.get(i) + nums.get(j) < k) {
//                 i++;
//             } else if (nums.get(i) + nums.get(j) > k) {
//                 j--;
//             } else {
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     private void inOrder(TreeNode root, List<Integer> nums) {
//         if (root == null) {
//             return;
//         }
//         inOrder(root.left, nums);
//         nums.add(root.val);
//         inOrder(root.right, nums);
//     }
        
        //M2: we can optimize the space to O(height of tree), we use 2 iterator of opposite direction
        //true -> from left to right to iterate
        BSTIterator left = new BSTIterator(root, true);
        BSTIterator right = new BSTIterator(root, false);
        while (left.hasNext() && right.hasNext()) {
            int l = left.peek();
            int r = right.peek();
            //teminate, we have traversed all the elment in the tree
            if (l >= r) {
                return false;
            }
            if (l + r < k) {
                left.next();
            } else if (l + r > k) {
                right.next();
            } else {
                return true;
            }
        }
        return false;
    }
    
    class BSTIterator {
        TreeNode root;
        //记录一个方向是从小往大还是从大到小
        boolean forward;
        //must store TreeNode not int because we cannot convert int to TreeNode when poll
        //keep the same type with root when iterate
        Deque<TreeNode> stack;
        
        public BSTIterator(TreeNode root, boolean forward) {
            this.root = root;
            this.forward = forward;
            stack = new ArrayDeque<>();
            if (forward) {
                pushAllLeft(root);
            } else {
                pushAllRight(root);
            }
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public int next() {
            TreeNode cur = stack.pollFirst();
            if (forward) {
                pushAllLeft(cur.right);
            } else {
                pushAllRight(cur.left);
            }
            return cur.val;
        }
        
        //把当前node所有一路向左的node都放入stack
        public void pushAllLeft(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
        }
        
        //把当前node所有一路向右的node都放入stack
        public void pushAllRight(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.right;
            }
        }
        
        public int peek() {
            return stack.peekFirst().val;
        }
    }
}