class Solution {
    /*
    //     overall, there are totally 4 scenarios will happen: 1.+ + 2.- - 3.+ - 4.- +
// when collision happens: only 3 which is + -
// use a stack to keep track of the previous and compare current value with previous ones
    stack:5 10
    if positive, push into stack
    if negative, case by case
    pop: 5 -6 prev is positive and keep poping
    if prev < 0, push
    if prev > 0, cur < 0, prev == cur, pop once
    */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int cur : asteroids) {
            if (cur > 0) {
                stack.offerFirst(cur);
            } else {
                // destroy the previous positive one(s) repeatedly
                while (!stack.isEmpty() && stack.peekFirst() > 0 && -cur > stack.peekFirst()) {
                    stack.pollFirst();
                }
                if (stack.isEmpty() || stack.peekFirst() < 0) {
                    stack.offerFirst(cur);
                } else if (stack.peekFirst() == -cur) {
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