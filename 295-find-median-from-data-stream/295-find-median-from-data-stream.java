class MedianFinder {
    /*
    2  3  |     4
maxHeap       minHeap
if size1 == size2 add to maxHeap
else add to minHeap
we should also guarantee the top of maxHeap <= top of minHeap

find median:if size1 == size2 (a + b) / 2
            else   maxHeap.peek
    */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.offer(num);
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return (double) (maxHeap.peek());
        }
    }
}

// class MedianFinder {
//     //small is maxHeap, large is a minHeap, small <= large the size of small and large is balanced
//     //1 2 3 small: 1 2 large: 3
//     //the size of small - the size of large <= 1
//     //最大堆里面放小的元素，栈顶是2。最小堆放大的，3
//     private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
//     private PriorityQueue<Integer> large = new PriorityQueue<>();
//     private boolean even = true;
    
//     public MedianFinder() {
        
//     }
// //     Time:
// // Constructor: O(1)
// // addNum: O(logN)
// // findMedian: O(1)
// // Space: O(N)
//     public void addNum(int num) {
//         if (even) {
//             //before:small 1 large:2   3
//             //after:small: 1 2 large: 3
//             //make sure small have more ele
//             large.offer(num);
//             small.offer(large.poll());
            
//         } else {
//             small.offer(num);
//             large.offer(small.poll());
//         }
//         even = !even;
//     }
    
//     public double findMedian() {
//         if (even) {
//             return (small.peek() + large.peek()) / 2.0;
//         } else {
//             return small.peek();
//         }
//     }
// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */