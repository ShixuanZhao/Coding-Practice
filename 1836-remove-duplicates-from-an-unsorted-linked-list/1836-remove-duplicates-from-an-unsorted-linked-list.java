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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //dummy
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = head;
        while(cur!=null)
        {
            map.put(cur.val,map.getOrDefault(cur.val,0)+1);
            cur = cur.next;                
        }
        ListNode prev = temp;
        cur = head;

        while(cur!=null)
        {
            if(map.get(cur.val)>1)
                prev.next = cur.next;
            else
                prev=cur;
                cur = cur.next;
        }

        return temp.next;
    }
}