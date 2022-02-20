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
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> res = new ArrayList<>();
//        dfs(root, "", res);
//         return res;
//     }
    
//     private void dfs(TreeNode root, String path, List<String> res) {
       
//         //preOrder
//         if (root == null) {
//             return;
//         }
       
//         if (root.left == null && root.right == null) {
//            res.add(path + root.val);
//             return;
//         }
//        dfs(root.left, path + root.val + "->", res);
//        dfs(root.right, path + root.val + "->", res);
//     }
    
     public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
       if (root == null) {
           return;
       }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            //not return because we have not got revoke the sb we should setLength
            // return;
        } else {
            sb.append("->");
            helper(root.left, sb, res);
            helper(root.right, sb, res);
        }
        sb.setLength(len);
    }
}


// class Solution {

//    List<String> res = new ArrayList<>();    // 存储结果
//    LinkedList<String> path = new LinkedList<>();  // 存储单个路径

//     public List<String> binaryTreePaths(TreeNode root) {
//         traverse(root);
//         return res;
//     }

//     // 二叉树的遍历框架
//     public void traverse(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         // 前序遍历位置
//         path.add(String.valueOf(root.val));
//         // 到叶子节点就返回
//         if (root.left == null && root.right == null) {
//             // 添加到结果中
//             res.add(String.join("->", path));
//         }
//         traverse(root.left);
//         traverse(root.right);
//         path.removeLast();
//     }
// }
