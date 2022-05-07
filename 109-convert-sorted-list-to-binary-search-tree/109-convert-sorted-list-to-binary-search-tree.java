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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //LinkedList的中点是root，但是没法快速找到中点对于链表
        //我们可以把链表的所有节点放在list里面，O（1）时间找到中点
        //但是用了额外的空间，也可以用快慢指针找中点，但是时间复杂度会高
        //更好的方法是按照链表的顺序，（相当于中序遍历），先构建左子树，再root，在右子树
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //维持一个全局的指针
        ListNode[] cur = new ListNode[] {head};
        return buildTree(0, length(head) - 1, cur);
    }

    TreeNode buildTree(int left, int right, ListNode[] cur) {
        if (left > right) {
            return null;
        }
        int mid  = left + (right - left + 1) / 2;
        TreeNode leftTree = buildTree(left, mid - 1, cur);
        //do something in the current layer
        TreeNode root = new TreeNode(cur[0].val);
        cur[0] = cur[0].next;
        root.left = leftTree;
        //
        root.right = buildTree(mid + 1, right, cur);
        return root;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}



//我洗的另一种方法
//如果把找中点放在dfs里面  O(n log(n))
// At every level, above algorithm is traversing the full list (in parts) and there are log(n) levels in balanced tree
// public TreeNode sortedListToBST(ListNode head) {
//         //LinkedList的中点是root，但是没法快速找到中点对于链表
//         //我们可以把链表的所有节点放在list里面，O（1）时间找到中点
//         //但是用了额外的空间，也可以用快慢指针找中点，但是时间复杂度会高
//         if (head == null) {
//             return null;
//         }
//         if (head.next == null) {
//             return new TreeNode(head.val);
//         }
//         List<Integer> list = new ArrayList<>();
//         while (head != null) {
//             list.add(head.val);
//             head = head.next;
//         }
//         return sortedListToBST(list, 0, list.size() - 1);
//     }

//     private TreeNode sortedListToBST(List<Integer> list, int left, int right) {
//         if (left > right) {
//             return null;
//         }
//         //是否+1都可以，+1是取得中间右边的那个，如果链表个数是偶数，可能有2种答案
//         int mid = left + (right - left + 1) / 2;
//         TreeNode root = new TreeNode(list.get(mid));
//         root.left = sortedListToBST(list, left, mid - 1);
//         root.right = sortedListToBST(list, mid + 1, right);
//         return root;
//     }