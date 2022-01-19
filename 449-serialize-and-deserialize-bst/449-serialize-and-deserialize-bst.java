/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //preOrder
        //Inorder to encode the string as compact as possible, we return"" when meeting null
        //Without using the symbol like "#", we can still find when we meet with null because we can utiliz the attribute of BST
        if (root == null) {
            return "";
        }
        String res = String.valueOf(root.val);
        if (root.left != null) {
            res += "," + serialize(root.left);
        }
        if (root.right != null) {
            res += "," + serialize(root.right);
        }
        return res;
        //return res + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    //<lower, upper>
    //we can only maintain the upper bound because preOrder一直往左是递增的
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<String> q, int lower, int upper) {
        //base case
        if (q.isEmpty()) {
            return null;
        }
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) {
            return null;
        }
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;