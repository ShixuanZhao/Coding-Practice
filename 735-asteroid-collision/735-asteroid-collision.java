class Solution {
    /*
    [10,2,-5]
           i
     stack:10 2
     +: push into stack
     -: 
     stack is empty or top < 0, push
     stack is not empty, cur > top, keep pop  
                 =,pop once
                 <, not pop
    */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int cur : asteroids) {
            if (cur > 0) {
                stack.offerFirst(cur);
            } else {
                while (!stack.isEmpty() && stack.peekFirst() > 0 && -cur > stack.peekFirst()) {
                    stack.pollFirst();
                }
                if (stack.isEmpty() || stack.peekFirst() < 0) {
                    stack.offerFirst(cur);
                }
                if (!stack.isEmpty() && -cur == stack.peekFirst()) {
                    stack.pollFirst();
                }
            }
        }
        int[] res = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pollFirst();
        }
        return res;
    }
}