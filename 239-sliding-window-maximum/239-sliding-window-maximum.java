class Solution {
    /* 解题函数的实现 */
//     单独看 push 操作的复杂度确实不是 O(1)，但是算法整体的复杂度依然是 O(N) 线性时间。要这样想，nums 中的每个元素最多被 push 和 pop 一次，没有任何多余操作，所以整体的复杂度还是 O(N)。

// 空间复杂度就很简单了，就是窗口的大小 O(k)。
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         MQ queue = new MQ();
//         int n = nums.length;
//         int[] res = new int[n - k + 1];
//         int index = 0;
//         for (int i = 0; i < n; i++) {
//             if (i < k - 1) {
//                 queue.push(nums[i]);
//             } else {
//                 queue.push(nums[i]);
//                 res[index++] = queue.max();
//                 queue.pop(nums[i - k + 1]);
//             }
//         }
//         return res;
//     }
    
//     //an decreasing queue. head is the largest ele
//     class MQ {
//         Deque<Integer> queue = new ArrayDeque<>();
//         public void push(int n) {
//             while (!queue.isEmpty() && n > queue.peekLast()) {
//                 queue.pollLast();
//             }
//             queue.offerLast(n);
//         }
        
//         public int max() {
//             return queue.peekFirst();
//         }
        
//         public void pop(int n) {
//             if (queue.peekFirst() == n) {
//                 queue.pollFirst();
//             }
//         }
//     }
    
    /*
        brute force:n * k
        T = O(nlogk)
        maxHeap: (2,-1) (3,-3) (4,5) (6,6) (7, 7)
        res:[3,3,5 5 5 7]
                0 1  2  3 4 5 6 7
        nums = [1,3,-1,-3,5,3,6,7], k = 3
                            l     
                                r
               
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Pair[0] is the index, Pair[1] is the val
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[] {i, nums[i]});
        }
        int index = 0;
        res[index++] = maxHeap.peek()[1];
        for (int i = k; i < n; i++) {
            //out
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] < i - k + 1) {
                maxHeap.poll();
            }
            maxHeap.offer(new int[] {i, nums[i]});
            res[index++] = maxHeap.peek()[1];
        }
        return res;
    }
}