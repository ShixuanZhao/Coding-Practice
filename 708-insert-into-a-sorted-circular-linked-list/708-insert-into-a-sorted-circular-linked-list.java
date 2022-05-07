/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node r = new Node(insertVal,null);
        
        if(head == null){
            r.next = r;
            return r;
        }
        
        Node n = head;
        
        /* 3 cases
            case 1: insertVal is between 2 nodes 
            e.g. 1->2->4, insert 3
            condition: insertVal >= n.val && insertVal <= n.next.val
        
            case 2: insertVal is >= largest node value or <= smalles node value 
            e.g. 1->2->4, insert 0 or 1->2->4, insert 5
            condition: n.next.val < n.val && (insertVal >= n.val || insertVal <= n.next.val)
        
            case 3: all the nodes in the tree have same value
            e.g. 1->1->1, insert 2
            condition: n.next == head 
        */
        while(true){
            if((insertVal >= n.val && insertVal <= n.next.val)
               || (n.next.val < n.val && (insertVal >= n.val || insertVal <= n.next.val))
               || n.next == head){
                r.next = n.next;
                n.next = r;
                break;
            }
            n = n.next;
        }
        
        return head;
    }
}