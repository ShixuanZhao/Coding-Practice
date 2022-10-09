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
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                //use 'X' to represent null
                sb.append('X').append(',');
            } else {
                sb.append(cur.val).append(',');
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        if (val[0] == "X") {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(val[0]));
        q.offer(root);
        int i = 1;
        while (i < val.length) {
            TreeNode cur = q.poll();
            if (!val[i].equals("X")) {
                TreeNode left = new TreeNode(Integer.valueOf(val[i]));
                cur.left = left;
                q.offer(left);
            }
            i++;
            if (!val[i].equals("X")) {
                TreeNode right = new TreeNode(Integer.valueOf(val[i]));
                cur.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
    
    //using preOrder is easier
    // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         //preorder         
//         if (root == null) {
//             return "#";
//         }
//         return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
//         return helper(q);
//     }
    
//     private TreeNode helper(Queue<String> q) {
//         String s = q.poll();
//         if (s.equals("#")) {
//             return null;
//         }
//         TreeNode root = new TreeNode(Integer.valueOf(s));
//         root.left = helper(q);
//         root.right = helper(q);
//         return root;
//     }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));