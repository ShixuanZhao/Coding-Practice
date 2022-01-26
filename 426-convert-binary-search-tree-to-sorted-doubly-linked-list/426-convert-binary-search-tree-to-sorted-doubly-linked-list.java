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
        //!!!!!do not forget to check the corner case otherwise it would cause NPE
        if (root == null) {
            return root;
        }
        Node[] head = new Node[1];
        //pre must be global variable
        Node[] pre = new Node[1];
        helper(root, pre, head);
        //must add this step because we need a circular doubly linked list
        head[0].left = pre[0];
        pre[0].right = head[0];
        return head[0];
    }
    
    private void helper(Node root, Node[] pre, Node[] head) {
        if (root == null) {
            return;
        }
        helper(root.left, pre, head);
        if (head[0] == null) {
            head[0] = root;
        }
        if (pre[0] != null) {
            pre[0].right = root;
            root.left = pre[0];
        }
        pre[0] = root;
        helper(root.right, pre, head);
    }
}