/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
		// public Node connect(Node root) {
		// if(root==null) {
		// 	return root;
		// }
		// LinkedList<Node> queue = new LinkedList<Node>();
		// queue.add(root);
		// while(queue.size()>0) {
		// 	int size = queue.size();
		// 	//将队列中的元素串联起来
		// 	Node tmp = queue.get(0);
		// 	for(int i=1;i<size;++i) {
		// 		tmp.next = queue.get(i);
		// 		tmp = queue.get(i);
		// 	}
		// 	//遍历队列中的每个元素，将每个元素的左右节点也放入队列中
		// 	for(int i=0;i<size;++i) {
		// 		tmp = queue.remove();
		// 		if(tmp.left!=null) {
		// 			queue.add(tmp.left);
		// 		}
		// 		if(tmp.right!=null) {
		// 			queue.add(tmp.right);
		// 		}
		// 	}
		// }
		// return root;
		// }
    
//     public Node connect(Node root) {
//        dfs(root, null);
//         return root;
//     }

//     private void dfs(Node root, Node next) {
//        //当前层只要next操作，next作为参数是上一层传过来的
//         if (root == null) {
//             return;
//         }
//         root.next = next;
//         dfs(root.left, root.right);
//         dfs(root.right, root.next == null ? null : root.next.left);
//     }
    
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNodes(root.left, root.right);
        return root;
    }
    
    //将每两个相邻节点都连接起来
    private void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node1.right, node2.left);
        connectTwoNodes(node2.left, node2.right);
        
    }
}