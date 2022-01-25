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
    // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    //     if (root1 == null || root2 == null) {
    //         return root1 == null ? root2 : root1;
    //     } 
    //     //重复利用一下t1这个树，t1就是合并之后树的根节点（就是修改了原来树的结构）。
    //     //当前层要做的是累加。遍历顺序无所谓
    //     root1.val += root2.val;
    //     root1.left = mergeTrees(root1.left, root2.left);
    //     root1.right = mergeTrees(root1.right, root2.right);
    //     return root1;
    // }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //case1:root1 and root2 are null
        //case2:one of the root is null
        //case3:neither are null
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            //copy root2
            TreeNode newRoot = new TreeNode(root2.val);
            newRoot.left = mergeTrees(null, root2.left);
            newRoot.right = mergeTrees(null, root2.right);
            return newRoot;
        } else if (root2 == null) {
            //copy root1
            TreeNode newRoot = new TreeNode(root1.val);
            newRoot.left = mergeTrees(root1.left, null);
            newRoot.right = mergeTrees(root1.right, null);
            return newRoot;
        } else {
            TreeNode newRoot = new TreeNode(root1.val + root2.val);
            newRoot.left = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);
            return newRoot;
        }
    }
}


 // 使用队列迭代
    // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    //     if (root1 == null) return root2;
    //     if (root2 ==null) return root1;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root1);
    //     queue.offer(root2);
    //     while (!queue.isEmpty()) {
    //         TreeNode node1 = queue.poll();
    //         TreeNode node2 = queue.poll();
    //         // 此时两个节点一定不为空，val相加
    //         node1.val = node1.val + node2.val;
    //         // 如果两棵树左节点都不为空，加入队列
    //         if (node1.left != null && node2.left != null) {
    //             queue.offer(node1.left);
    //             queue.offer(node2.left);
    //         }
    //         // 如果两棵树右节点都不为空，加入队列
    //         if (node1.right != null && node2.right != null) {
    //             queue.offer(node1.right);
    //             queue.offer(node2.right);
    //         }
    //         //至少有一个node为空
    //         // 若node2的左节点空，直接赋值,改变树的结构
    //         if (node1.left == null && node2.left != null) {
    //             node1.left = node2.left;
    //         }
    //         // 若node2的右节点空，直接赋值,改变树的结构
    //         if (node1.right == null && node2.right != null) {
    //             node1.right = node2.right;
    //         }
    //     }
    //     return root1;
    // }
