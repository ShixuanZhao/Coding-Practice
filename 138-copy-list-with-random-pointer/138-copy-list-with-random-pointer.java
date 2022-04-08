/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if (head == null) {
        //     return null;
        // }
        // Map<Node, Node> copied = new HashMap<>();
        // Node newHead = new Node(head.val);
        // copied.put(head, newHead);
        // Node cur = newHead;
        // while (head != null) {
        //     //copy next
        //     if (head.next != null) {
        //         if (!copied.containsKey(head.next)) {
        //             copied.put(head.next, new Node(head.next.val));
        //         }
        //         cur.next = copied.get(head.next);
        //     }
        //     //copy random
        //     if (head.random != null) {
        //         if (!copied.containsKey(head.random)) {
        //             copied.put(head.random, new Node(head.random.val));
        //         }
        //         cur.random = copied.get(head.random);
        //     }
        //     head = head.next;
        //     cur = cur.next;
        // }
        // return newHead;
        
        //recursion
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return helper(head, map);
    }
    
    private Node helper(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = helper(head.next, map);
        newNode.random = helper(head.random, map);
        return newNode;
    }
}