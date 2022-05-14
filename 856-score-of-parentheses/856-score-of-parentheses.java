class Solution {
    /*
    (())
       i
    cur:1 
    stack:0 1
    */
    public int scoreOfParentheses(String s) {
        //score of current level
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(cur);
                cur = 0;
            } else {
                cur = Math.max(cur * 2, 1) + stack.pollFirst();
            }
        }
        return cur;
    }
}