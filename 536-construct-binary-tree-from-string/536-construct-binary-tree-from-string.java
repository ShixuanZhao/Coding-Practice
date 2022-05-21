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
    //找左右边界，缩小范围。遇到这种（）嵌套的，都是recursion
    public TreeNode str2tree(String s) {
        System.out.println(s);
        if (s == null || s.length() == 0) {
            return null;
        }
        //find the root
        TreeNode root = null;
        int index = s.indexOf("(");
        if (index == -1) {
            root = new TreeNode(Integer.valueOf(s.substring(0, s.length())));
            return root;
        } else {
            root = new TreeNode(Integer.valueOf(s.substring(0, index)));
        }
        int left_bound = index;
        //parenthensis matching
        int leftCnt = 0;
        int i = index;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCnt++;
            }
            if (s.charAt(i) == ')') {
                leftCnt--;
            }
            if (leftCnt == 0) {
                break;
            }
        }
        root.left = str2tree(s.substring(left_bound + 1, i));
        //！may be there is no ")"
        if (i != s.length() - 1) {
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        }
        return root;
    }
}