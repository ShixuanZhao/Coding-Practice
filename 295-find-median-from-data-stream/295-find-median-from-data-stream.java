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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */