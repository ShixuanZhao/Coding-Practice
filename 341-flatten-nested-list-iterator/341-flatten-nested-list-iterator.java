/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator implements Iterator<Integer> {
//      private LinkedList<NestedInteger> list;
//     // 等价于遍历一棵 N 叉树的所有「叶子节点
//     public NestedIterator(List<NestedInteger> nestedList) {
//         // 不直接用 nestedList 的引用，是因为不能确定它的底层实现
//         // 必须保证是 LinkedList，否则下面的 addFirst 会很低效
//         list = new LinkedList<>(nestedList);
//     }

//     @Override
//     public Integer next() {
//         // hasNext 方法保证了第一个元素一定是整数类型
//         return list.remove(0).getInteger();
//     }
// // 调用hasNext时，如果nestedList的第一个元素是列表类型，则不断展开这个元素，直到第一个元素是整数类型。

// // 由于调用next方法之前一定会调用hasNext方法，这就可以保证每次调用next方法的时候第一个元素是整数型，直接返回并删除第一个元素即可。
//     @Override
//     public boolean hasNext() {
//         // 循环拆分列表元素，直到列表第一个元素是整数类型
//         while (!list.isEmpty() && !list.get(0).isInteger()) {
//             // 当列表开头第一个元素是列表类型时，进入循环
//             List<NestedInteger> first = list.remove(0).getList();
//             // 将第一个列表打平并按顺序添加到开头
//             for (int i = first.size() - 1; i >= 0; i--) {
//                 list.addFirst(first.get(i));
//             }
//         }
//         return !list.isEmpty();
//     }
// }

public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue = new LinkedList();
    
    public NestedIterator(List<NestedInteger> nestedList) {
            helper(nestedList);
    }
    
    private void helper(List<NestedInteger> list){
        if (list == null)
            return;
        
        for (NestedInteger in: list){
            if (in.isInteger())
                queue.offer(in.getInteger());
            else{
                helper(in.getList());
            }
            
        }
    }

    @Override
    public Integer next() {
        if (hasNext()){
            return queue.poll();
        }
        else
            return -1;
    }

    @Override
    public boolean hasNext() {
        if (!queue.isEmpty())
            return true;
        else
            return false;
    }
}



// class NestedIterator implements Iterator<Integer> {

//     private Iterator<Integer> it;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         // 存放将 nestedList 打平的结果
//         List<Integer> result = new LinkedList<>();
//         for (NestedInteger node : nestedList) {
//             // 以每个节点为根遍历
//             traverse(node, result);
//         }
//         // 得到 result 列表的迭代器
//         this.it = result.iterator();
//     }

//     public Integer next() {
//         return it.next();
//     }

//     public boolean hasNext() {
//         return it.hasNext();
//     }    

//     // 遍历以 root 为根的多叉树，将叶子节点的值加入 result 列表
//     private void traverse(NestedInteger root, List<Integer> result) {
//         if (root.isInteger()) {
//             // 到达叶子节点
//             result.add(root.getInteger());
//             return;
//         }
//         // 遍历框架
//         for (NestedInteger child : root.getList()) {
//             traverse(child, result);
//         }
//     }
// }

// public class NestedInteger {
//     private Integer val;
//     private List<NestedInteger> list;

//     public NestedInteger(Integer val) {
//         this.val = val;
//         this.list = null;
//     }
//     public NestedInteger(List<NestedInteger> list) {
//         this.list = list;
//         this.val = null;
//     }

//     // 如果其中存的是一个整数，则返回 true，否则返回 false
//     public boolean isInteger() {
//         return val != null;
//     }

//     // 如果其中存的是一个整数，则返回这个整数，否则返回 null
//     public Integer getInteger() {
//         return this.val;
//     }

//     // 如果其中存的是一个列表，则返回这个列表，否则返回 null
//     public List<NestedInteger> getList() {
//         return this.list;
//     }
// }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */