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
    private static final String SPLITTER = ",";
    private static final String NN = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                sb.append(NN).append(SPLITTER);
            } else {
                sb.append(cur.val).append(SPLITTER);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(SPLITTER);
        if (values[0].equals(NN)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int index = 1;
        while (index < values.length) {
            TreeNode cur = q.poll();
            if (!values[index].equals(NN)) {
                TreeNode left = new TreeNode(Integer.valueOf(values[index]));
                cur.left = left;
                q.offer(left);
            }
            index++;
            if (!values[index].equals(NN)) {
                TreeNode right = new TreeNode(Integer.valueOf(values[index]));
                cur.right = right;
                q.offer(right);
            }
            index++;
        }
        return root;
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
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));