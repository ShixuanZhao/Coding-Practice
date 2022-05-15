class CustomStack {
    int size;
    Deque<Integer> stack;
    public CustomStack(int maxSize) {
        size = maxSize;
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.size() < size) {
            stack.offerFirst(x);
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pollFirst();
    }
    
    public void increment(int k, int val) {
        Deque<Integer> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            temp.offerFirst(stack.pollFirst());
        }
        while (k-- > 0) {
            if (!temp.isEmpty()) {
                stack.offerFirst(temp.pollFirst() + val);
            } else {
                return;
            }
        }
        while (!temp.isEmpty()) {
            stack.offerFirst(temp.pollFirst());
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