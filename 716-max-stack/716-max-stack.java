class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.offerFirst(x);
            maxStack.offerFirst(x);
            return;
        }
        stack.offerFirst(x);
        int max = maxStack.peekFirst();
        maxStack.offerFirst(Math.max(max, x));
    }
    
    public int pop() {
        maxStack.pollFirst();
        return stack.pollFirst();
    }
    
    public int top() {
       return stack.peekFirst();
    }
    
    public int peekMax() {
        return maxStack.peekFirst();
    }
    
    //T = O(n)更好的方法是logN
    //maxStack and stack同步加同步减
    public int popMax() {
        //use a temp stack
        Deque<Integer> temp = new ArrayDeque<>();
        int max = maxStack.peekFirst();
        while (!stack.isEmpty() && stack.peekFirst() != max) {
            temp.offerFirst(stack.pollFirst());
            maxStack.pollFirst();
        }
        stack.pollFirst();
        maxStack.pollFirst();
        while (!temp.isEmpty()) {
            push(temp.pollFirst());
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */