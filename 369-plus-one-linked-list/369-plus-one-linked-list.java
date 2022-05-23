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
//     public ListNode plusOne(ListNode head) {
//         if (head == null) {
//             return null;
//         }
//         if (addWithCarry(head) == 0) {
//             return head;
//         } else {
//             ListNode newNode = new ListNode(1);
//             newNode.next = head;
//             return newNode;
//         }
//     }
    
//     ////adding one from tail and return the carry on the head
//     private int addWithCarry(ListNode head) {
//         if (head == null) {
//             return 1;
//         }
//         int res = head.val + addWithCarry(head.next);
//         head.val = res % 10;
//         return res / 10;
//     }
    
    //set a global carry
    int carry = 0;
    public ListNode plusOne(ListNode head) {
        ListNode head1 = helper(head);
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head1;
            return newNode;
        } else {
            return head1;
        }
    }
    
    private ListNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head.val += 1;
            if (head.val == 10) {
                head.val = 0;
                carry = 1;
            }
            return head;
        }
        head.next = helper(head.next);
        if (carry == 1) {
            head.val++;
            carry = 0;
        }
        if (head.val == 10) {
            head.val = 0;
            carry = 1;
        }
        return head;
    }
}