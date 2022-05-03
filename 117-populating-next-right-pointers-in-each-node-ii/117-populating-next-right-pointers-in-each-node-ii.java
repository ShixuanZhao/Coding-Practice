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
    //      if (root == null) {
    //          return null;
    //      }
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
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
    
    //S = O(1)
   public Node connect(Node root) {
       if (root == null) {
           return null;
       }
       Node head = root;
       //level order
       while (head != null) {
           Node dummy = new Node(0);
           Node temp = dummy;
           //same level
           //head is the upper layer
           while (head != null) {
               if (head.left != null) {
                   temp.next = head.left;
                   temp = temp.next;
               }
               if (head.right != null) {
                   temp.next = head.right;
                   temp = temp.next;
               }
               head = head.next;
           }
           //go to next layer
           head = dummy.next;
       }
       return root;
   }
       
}