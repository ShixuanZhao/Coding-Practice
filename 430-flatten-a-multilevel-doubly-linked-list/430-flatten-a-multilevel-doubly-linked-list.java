/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
// Start form the head , move one step each time to the next node
// When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
// Return to p and proceed until find next node with child.
// Repeat until reach null
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            /* CASE 1: if no child, proceed */
            if (cur.child == null) {
                cur = cur.next;
            } else {
                 /* CASE 2: got child, find the tail of the child and link it to p.next */
                Node temp = cur.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                // Connect tail with p.next, if it is not null
                temp.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = temp;
                }
                // Connect p with p.child, and remove p.child
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }
}