// class CustomStack {
//     int size;
//     Deque<Integer> stack;
//     public CustomStack(int maxSize) {
//         size = maxSize;
//         stack = new ArrayDeque<>();
//     }
    
//     public void push(int x) {
//         if (stack.size() < size) {
//             stack.offerFirst(x);
//         }
//     }
    
//     public int pop() {
//         if (stack.isEmpty()) {
//             return -1;
//         }
//         return stack.pollFirst();
//     }
    
//     public void increment(int k, int val) {
//         Deque<Integer> temp = new ArrayDeque<>();
//         while (!stack.isEmpty()) {
//             temp.offerFirst(stack.pollFirst());
//         }
//         while (k-- > 0) {
//             if (!temp.isEmpty()) {
//                 stack.offerFirst(temp.pollFirst() + val);
//             } else {
//                 return;
//             }
//         }
//         while (!temp.isEmpty()) {
//             stack.offerFirst(temp.pollFirst());
//         }
//     }    
// }

// class CustomStack {
//     List<Integer> list;
//     int n;
//     public CustomStack(int maxSize) {
//         n = maxSize;
//         list = new ArrayList<>();
//     }
    
//     public void push(int x) {
//         if (list.size() < n) {
//             list.add(x);
//         }
//     }
    
//     public int pop() {
//         if (list.size() <= 0) {
//             return -1;
//         }
//         int res = list.get(list.size() - 1);
//         list.remove(list.size() - 1);
//         return res;
//     }
    
//     public void increment(int k, int val) {
//         for (int i = 0; i < Math.min(k, list.size()); i++) {
//             list.set(i, list.get(i) + val);
//         }
//     }
// }

//Lazy increment
/*
Use an additional array to record the increment value.
inc[i] means for all elements stack[0] ~ stack[i],
we should plus inc[i] when popped from the stack.
Then inc[i-1]+=inc[i],
so that we can accumulate the increment inc[i]
for the bottom elements and the following pops.
*/

class CustomStack {
    int n;
    int[] inc;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        n = maxSize;
        inc = new int[n];
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() < n)
            stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0)
            return -1;
        if (i > 0)
            inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0)
            inc[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
