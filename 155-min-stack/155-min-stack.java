class MinStack {
    /*
        operation:push(-2), push(0), push(-3), pop()
        stack1(input):-2, 0, 
        stack2(hold the min element):-2
        rule:push:push element is smaller or equal than stack2.top() || stack2 is empty ,update stack2
            pop:if poped element == stack2.top(), pop in stack2
    */
//     Deque<Integer> stack1;
//     //store cur min
//     Deque<Integer> stack2;
//     public MinStack() {
//         stack1 = new ArrayDeque<>();
//         stack2 = new ArrayDeque<>();
//     }
    
//     public void push(int val) {
//         stack1.offerFirst(val);
//         if (stack2.isEmpty() || val <= stack2.peekFirst()) {
//             stack2.offerFirst(val);
//         }
//     }
    
//     public void pop() {
//         int temp = stack1.pollFirst();
//         if (temp == stack2.peekFirst()) {
//             stack2.pollFirst();
//         }
//     }
    
//     public int top() {
//         return stack1.peekFirst();
//     }
    
//     public int getMin() {
//         return stack2.peekFirst();
//     }
    
    //one stack solution
    //maintain a pair in stack record the curVal and curMin
    Deque<Pair> stack = new ArrayDeque<>();
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.offerFirst(new Pair(val, val));
            return;
        }
        int curMin = stack.peekFirst().min;
        stack.offerFirst(new Pair(val, Math.min(curMin, val)));
    }
    
    public void pop() {
        stack.pollFirst();
    }
    
    public int top() {
       return stack.peekFirst().val;
    }
    
    public int getMin() {
        return stack.peekFirst().min;
    }
    
    class Pair {
        int val;
        int min;
        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */