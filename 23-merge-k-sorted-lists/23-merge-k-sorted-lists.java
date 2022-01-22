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
    /*
    1 4 5
      i
    1 3 4
    j
    2 6
    k
    step1:minHeap:find the smallest element in k elements, and add it to the result list
    step2:move the smallest pointer, repeat the step 1 until there is no element in the heap
    T = O(n * k * log(k)) n is the number of ListNode in the input list   S = O(k)
    
    M2:iterative reduction
    step1:merge the first two list
    1 4 5   a
    i
    1 3 4  b  move the smallest pointer by one step, and merge them to one list c
    j
    step2:merge c and d(3rd list int the input)
    step3:repeat until all the list has been merged
    */
    public ListNode mergeKLists(ListNode[] lists) {
        // ListNode dummy = new ListNode();
        // ListNode cur = dummy;
        // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // for (ListNode list : lists) {
        //     if (list != null) {
        //         minHeap.offer(list);
        //     }
        // }
        // while (!minHeap.isEmpty()) {
        //     ListNode temp = minHeap.poll();
        //     cur.next = temp;
        //     if (temp.next != null) {
        //         minHeap.offer(temp.next);
        //     }
        //     cur = cur.next;
        // }
        // return dummy.next;
        
        //M2  define the average length of each list is n
        //A1,A2 -> A12(2n)  A12, A3 -> A13(3n)   2n + 3n +...+ kn = k^2 * n  
        //T = O(k^2 * n) S = O(kn)
//         ListNode dummyList = null;
//         for (ListNode list : lists) {
//             dummyList = merge(dummyList, list);
//         }
//         return dummyList;
//     }
    
//     //merge two list
//     /*
//     1 (2 3)
//     4 (1 3)
//     */
//     private ListNode merge(ListNode one, ListNode two) {
//         if (one == null) {
//             return two;
//         }
//         if (two == null) {
//             return one;
//         }
//         if (one.val < two.val) {
//             one.next = merge(one.next, two);
//             return one;
//         } else {
//             two.next = merge(one, two.next);
//             return two;
//         }
        /*
        binary reduction:  a1
                               a12 (2n)
                           a2
                                     a14  (4n)
                           a3
                               a34 (2n)
                           a4
                           T = O(logk * k * n)  S = O(kn)
                                                           
        */
        //divide and conquer
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    } 
    
    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftRes = mergeKLists(lists, left, mid);
        ListNode rightRes = mergeKLists(lists, mid + 1, right);
        return merge(leftRes, rightRes);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 == null) {
            cur.next = node2;
        }
        if (node2 == null) {
            cur.next = node1;
        }
        return dummy.next;
    }
}