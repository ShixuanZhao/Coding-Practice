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
}