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
            if (l >= r) {
                return false;
            }
            if (l + r < k) {
                left.next();
            } else if (l + r == k) {
                return true;
            } else {
                right.next();
            }
        }
        return false;
    }
    
    class BSTIterator {
        TreeNode root;
        //from left to right
        boolean isLeft;
        Deque<TreeNode> stack;
        
        public BSTIterator(TreeNode root, boolean isLeft) {
            this.root = root;
            this.isLeft = isLeft;
            stack = new ArrayDeque<>();
            if (isLeft) {
                pushAllLeft(root);
            } else {
                pushAllRight(root);
            }
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public int next() {
            TreeNode root = stack.pollFirst();
            if (isLeft) {
                pushAllLeft(root.right);
            } else {
                pushAllRight(root.left);
            }
            return root.val;
        }
        
        public int peek() {
            return stack.peekFirst().val;
        }
        
        private void pushAllLeft(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
        }
        
        private void pushAllRight(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.right;
            }
        }
    }
}