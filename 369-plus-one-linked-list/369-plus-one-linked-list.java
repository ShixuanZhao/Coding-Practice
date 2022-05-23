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
//     public ListNode plusOne(ListNode head) {
//         head = reverse(head);
//         //use dummy node to avoid the corner case of onlt one node
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode x = dummy;
//         int carry = 1;
//         while (carry > 0 || x.next != null) {
//             if (x.next != null) {
//                 x = x.next;
//                 carry += x.val;
//                 x.val = carry % 10;
//                 carry /= 10;
//             }
//             else {
//                 x.next = new ListNode(carry);
//                 x = x.next;
//                 carry = 0;
//             }
//         }
//         return reverse(dummy.next);
//     }
    
//     private ListNode reverse(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode cur = head;
//         ListNode prev = null;
//         while (cur != null) {
//             ListNode next = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = next;
//         }
//         return prev;
//     }
    
    //recursion
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        if (addWithCarry(head) == 0) {
            return head;
        } else {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
    }
    
    private int addWithCarry(ListNode head) {
        if (head == null) {
            return 1;
        }
        int res = head.val + addWithCarry(head.next);
        head.val = res % 10;
        return res / 10;
            
    }
    
    
}