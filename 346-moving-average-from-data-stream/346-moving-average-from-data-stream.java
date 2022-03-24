class MovingAverage {
    int size;
    Queue<Integer> q;
    double sum;
    public MovingAverage(int size) {
        this.size = size;
        q = new ArrayDeque<>();
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        q.offer(val);
        if (q.size() > size) {
            int temp = q.poll();
            sum -= temp;
        }
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */