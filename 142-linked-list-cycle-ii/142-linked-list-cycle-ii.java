/**
 * Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
 }
 */
public class Solution {
    //快慢指针，先找到快慢的交互点，证明有环
    //交汇点和head一起往前走，同样的速度，交汇就是所求点
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        } 
        return null;
    }
}