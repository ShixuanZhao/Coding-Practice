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
    brute force:
    1 collect all leaf node O(n)
    2 enumerate all pairs O(n^2)
        check the distance between two nodes (LCA)
    */
    private int res = 0, dist = 0;
    
    public int countPairs(TreeNode root, int distance) {
        dist = distance;
        helper(root);
        return res;
    }
    
    //for each node, return a int[] size == distance
    //for node1 [0, 1, 1] 代表距离node1 distance为1的有一个，2的有一个 {distance, # of leaf nodes}
    private int[] helper(TreeNode n) {
        int[] arr = new int[dist + 1];
        if(n == null)
            return arr;
        if(n.left == null && n.right == null) {
            //距离他的parentdis为1 有一个
            arr[1] = 1;
            return arr;
        }
        int[] left = helper(n.left);
        int[] right = helper(n.right);
        
        for(int i = 1; i < dist; i++) {
            for(int j = 1; j < dist; j++) {
                if(i + j <= dist)
                    res += (left[i] * right[j]);
            }
        }
        
        for(int i = dist; i > 0; i--) 
            //距离+1，个数相加
            arr[i] += (left[i - 1] + right[i - 1]);
        return arr;
    }
}