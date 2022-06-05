/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //recursion:like postorder
    int res = 0;
    //a global var, at first point to head, and then be updated from left to right
    ListNode forward;
    public int pairSum(ListNode head) {
        forward = head;
        dfs(head);
        return res;
    }
    
    private void dfs(ListNode backward) {
        if (backward == null) {
            return;
        }
        dfs(backward.next);
        res = Math.max(res, forward.val + backward.val);
        forward = forward.next;
    }
    //M2
    //Here we first find the middle of the linked list.
// Then after finding the middle, we just reverse all the nodes from the middle
// Now we keep 2 pointer one pointing to the head and the other pointing to the starting of the reversed part.
// Just find the maximum twin sum until the pointer pointing to the reversed part reaches null.
}