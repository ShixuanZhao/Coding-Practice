/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
        
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //method1 trancate the longer LinkedList and let the two list have the same length, and then begin to tranverse
//         int lenA = getLength(headA);
//         int lenB = getLength(headB);
//         ListNode a = headA;
//         ListNode b = headB;
//         while (lenA > lenB) {
//             a = a.next;
//             lenA--;
//         }
//         while (lenB > lenA) {
//             b = b.next;
//             lenB--;
//         }
//         //begin to traverse
//         while (a != null && b != null) {
//             if (a == b) {
//                 return a;
//             }
//             a = a.next;
//             b = b.next;
//         }
//         return null;
//     }
    
//     private int getLength(ListNode head) {
//         int len = 0;
//         while (head != null) {
//             len++;
//             head = head.next;
//         }
//         return len;
        
        //method2:一个走完在从另一个的head开始走，这样一定会在交汇点相遇
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}