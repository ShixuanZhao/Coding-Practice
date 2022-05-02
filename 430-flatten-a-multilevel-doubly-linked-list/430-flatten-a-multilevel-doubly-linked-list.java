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
    
    //flatten the list and return the tail after flatten
    //the tail means the last node after flattening "head"
    
    // Five situations:
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next - flatten the child, connect it with the next, go next
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

// Start form the head , move one step each time to the next node
// When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
// Return to p and proceed until find next node with child.
// Repeat until reach null
// class Solution {
//     public Node flatten(Node head) {
//         if (head == null) {
//             return head;
//         }
//         Node cur = head;
//         while (cur != null) {
//             /* CASE 1: if no child, proceed */
//             if (cur.child == null) {
//                 cur = cur.next;
//             } else {
//                  /* CASE 2: got child, find the tail of the child and link it to p.next */
//                 Node temp = cur.child;
//                 while (temp.next != null) {
//                     temp = temp.next;
//                 }
//                 // Connect tail with p.next, if it is not null
//                 temp.next = cur.next;
//                 if (cur.next != null) {
//                     cur.next.prev = temp;
//                 }
//                 // Connect p with p.child, and remove p.child
//                 cur.next = cur.child;
//                 cur.child.prev = cur;
//                 cur.child = null;
//             }
//         }
//         return head;
//     }
// }