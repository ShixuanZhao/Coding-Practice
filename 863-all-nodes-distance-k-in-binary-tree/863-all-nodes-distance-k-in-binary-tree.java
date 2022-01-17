/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //BFS建图，从target到他所有上面的node，map储存子节点到父节点的映射
        //从target开始bfs，向上面还有下面
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //一定要去重，因为还有hashmap里面的内容加入queue，画图看看generate rule
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(root);
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == target) {
                break;
            }
            if (cur.left != null) {
                map.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
        //second bfs
        queue.clear();
        queue.offer(target);
        visited.add(target);
        //level order
        while (k-- > 0) {
            if (queue.isEmpty()) {
                //return a empty list
                return res;
            }
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                //generate rule
                if (cur.left != null && visited.add(cur.left)) {
                    queue.offer(cur.left);
                }
                if (cur.right != null && visited.add(cur.right)) {
                    queue.offer(cur.right);
                }
                if (map.get(cur) != null && visited.add(map.get(cur))) {
                    queue.offer(map.get(cur));
                }
            }
        }
        //now, pop the queue
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }
    
    
    
    
    
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         //dfs
//         //找到root到target直上直下的路径，用map记录这条路径上node到target的距离（find）
//         //得到路径的信息，从路径上的每个的点做dfs
//         Map<TreeNode, Integer> map = new HashMap<>();
//         List<Integer> res = new LinkedList<>();
//         find(root, target, map);
//         search(root, target, k, map, res, 0);
//         return res;
//     }
    
//     private void find(TreeNode root, TreeNode target, Map<TreeNode, Integer> map) {
//         if (root == null) {
//             return;
//         }
//         if (root == target) {
//             map.put(target, 0);
//             return;
//         }
//         find(root.left, target, map);
//         //postOrder
//         if (map.containsKey(root.left)) {
//             map.put(root, map.get(root.left) + 1);
//         }
//         find(root.right, target, map);
//         if (map.containsKey(root.right)) {
//             map.put(root, map.get(root.right) + 1);
//         }
//     }
    
//     private void search(TreeNode root, TreeNode target, int k, Map<TreeNode, Integer> map, List<Integer> res, int dis) {
//         if (root == null) {
//             return;
//         }
//         if (map.containsKey(root)) {
//             dis = map.get(root);
//         }
//         if (dis == k) {
//             res.add(root.val);
//         }
//         search(root.left, target, k, map, res, dis + 1);
//         search(root.right, target, k, map, res, dis + 1);
//     }
}