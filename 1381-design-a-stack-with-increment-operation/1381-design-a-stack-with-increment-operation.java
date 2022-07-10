class CustomStack {
    Deque<Integer> stack;
    int[] inc;
    int maxSize;
    public CustomStack(int maxSize) {
        stack = new ArrayDeque<>();
        inc = new int[maxSize];
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.offerFirst(x);
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int i = stack.size() - 1;
        if (i > 0) {
            inc[i - 1] += inc[i];
        }
        int res = stack.pollFirst() + inc[i];
        inc[i] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int index = Math.min(k, stack.size()) - 1;
        if (index < 0) {
            return;
        } else {
            inc[index] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */