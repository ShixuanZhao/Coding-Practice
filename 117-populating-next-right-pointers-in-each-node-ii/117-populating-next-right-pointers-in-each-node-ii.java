/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // public Node connect(Node root) {
    //     if (root == null) {
    //         return root;
    //     }
    //     Queue<Node> q = new ArrayDeque<>();
    //     q.offer(root);
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         Node prev = null;
    //         for (int i = 0; i < size; i++) {
    //             Node cur = q.poll();
    //             if (prev != null) {
    //                 prev.next = cur;
    //             }
    //             prev = cur;
    //             if (cur.left != null) {
    //                 q.offer(cur.left);
    //             }
    //             if (cur.right != null) {
    //                 q.offer(cur.right);
    //             }
    //         }
    //     }
    //     return root;
    // }
    
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //head is the head of the each level's LinkedList
        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node cur = dummy;
            while (head != null) {
                if (head.left != null) {
                    cur.next = head.left;
                    cur = cur.next;
                }
                if (head.right != null) {
                    cur.next = head.right;
                    cur = cur.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}