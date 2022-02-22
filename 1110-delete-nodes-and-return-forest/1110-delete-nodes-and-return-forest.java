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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 答题思路：创建一个set，保存要删除的节点，然后遍历原树，发现值在set中存在的，就把孩子节点加入到结果链表中。
        // 先递归遍历，再删除，效果就是遍历到最底层，再开始删除，然后才添加，就不会重复添加。
        // 递归返回的是null 或者是传入递归的节点，这个节点如果是需要删除的 那么也是null
        // 最后记得把根节点加入结果链表。
        // 注意：递归之后会把根加点加入结果链表，也就是整颗数，当然递归后不会包括被删除的节点。
        // 递归的中间会删除掉一些节点，这个时候他的子树会不在树上，所以需要手动将这些孩子加到结果集中
        List<TreeNode> res = new LinkedList<>();
        Set<Integer> delete = new HashSet<>();
        for (int cur : to_delete) {
            delete.add(cur);
        }
        // 递归遍历跟节点 遍历的时候会进行删除
        root = helper(root, delete, res);
        // 判断跟节点是否被删除，如果没有那么加入链表
        if (root != null) {
            res.add(root);
        }
        return res;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> delete, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        // 先递归 也即是先递归到最深的层，然后再开始执行删除添加操作
        //三部曲：postOrder
        root.left = helper(root.left, delete, res);
        root.right = helper(root.right, delete, res);
        // 递归完，判断当前的节点是否需要删除，如果需要删除，还需要判断是否有孩子，
        // 如果孩子不为空，那么加入结果集。这里的孩子是已经经过删除判断的，
        // 因为是递归到最深的一层才开始执行删除判断的
        // 所以如果不为空，就需要加入结果集
        if (delete.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            //!!!
            return null;
        }
        // 如果不需要回收，那么返回当前的节点
        // 不需要回收的节点会继续留在树上，最后和根节点一起加入结果集，
        // 如果根节点需要删除，那么会和根节点的子树一起被加到结果集，
        // 所以不用删除的节点不用手动介入结果集，它的父类会被加入。
        return root;
    }
}