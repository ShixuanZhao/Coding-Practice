class MedianFinder {
    //small is maxHeap, large is a minHeap, small <= large the size of small and large is balanced
    //1 2 3 small: 1 2 large: 3
    //the size of small - the size of large <= 1
    //最大堆里面放小的元素，栈顶是2。最小堆放大的，3
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;
    
    public MedianFinder() {
        
    }
//     Time:
// Constructor: O(1)
// addNum: O(logN)
// findMedian: O(1)
// Space: O(N)
    public void addNum(int num) {
        if (even) {
            //before:small 1 large:2   3
            //after:small: 1 2 large: 3
            //make sure small have more ele
            large.offer(num);
            small.offer(large.poll());
            
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */