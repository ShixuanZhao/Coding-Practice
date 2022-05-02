/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    /*
    iterate the node:
    case1:if do not have child, cotinue to next node
    case2:if have child, call recursion
    base case: node is null
    cur.next = flatten(node.child);
    10->4
    */
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        flattenTail(head);
        return head;
    }
    
    //flatten the list and return the tail
    private Node flattenTail(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        if (cur.child == null) {
            if (cur.next == null) {
                return cur;
            }
            return flattenTail(cur.next);
        } else {
            Node child = cur.child;
            cur.child = null;
            Node next = cur.next;
            cur.next = child;
            child.prev = cur;
            Node tail = flattenTail(child);
            if (next != null) {
                tail.next = next;
                next.prev = tail;
                return flattenTail(next);
            } 
            return tail;
        }
    }
}