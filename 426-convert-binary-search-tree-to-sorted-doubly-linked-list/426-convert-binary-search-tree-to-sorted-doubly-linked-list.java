/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
       if (root == null) {
           return null;
       }
        Node[] head = new Node[1];
        Node[] prev = new Node[1];
        convert(root, head, prev);
        head[0].left = prev[0];
        prev[0].right = head[0];
        return head[0];
    }
    
    private void convert(Node root, Node[] head, Node[] prev) {
        if (root == null) {
            return;
        }
        convert(root.left, head, prev);
        if (head[0] == null) {
            head[0] = root;
        }
        if (prev[0] != null) {
            root.left = prev[0];
            prev[0].right = root;
        }
        prev[0] = root;
        convert(root.right, head, prev);
    }
}