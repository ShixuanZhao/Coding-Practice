class Solution {
    /*
    stack:1   
    [4,5,3,2,1]
             i 
    */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //use stack to simulate
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int cur : pushed) {
            stack.offerFirst(cur);
            while (!stack.isEmpty() && stack.peekFirst() == popped[i]) {
                stack.pollFirst();
                i++;
            }
        }
        return stack.isEmpty();
    }
}