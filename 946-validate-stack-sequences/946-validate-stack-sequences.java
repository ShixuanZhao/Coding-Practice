class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //use stack to simulate
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int p : pushed) {
            stack.offerFirst(p);
            while (!stack.isEmpty() && popped[i] == stack.peekFirst()) {
                stack.pollFirst();
                i++;
            }
        }
        return stack.isEmpty();
    }
}