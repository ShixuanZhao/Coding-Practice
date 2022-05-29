class Solution {
    public int calculate(String s) {
        int[] index = new int[1];
        return helper(s, index);
    }
    
    private int helper(String s, int[] index) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char operator = '+';
        while (index[0] < s.length()) {
            char c = s.charAt(index[0]++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = helper(s, index);
            }
            if (index[0] == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (operator == '+') {
                    stack.offerFirst(num);
                } else if (operator == '-') {
                    stack.offerFirst(-num);
                } else if (operator == '/') {
                    stack.offerFirst(stack.pollFirst() / num);
                } else {
                    stack.offerFirst(stack.pollFirst() * num);
                }
                num = 0;
                operator = c;
            }
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollFirst();
        }
        return res;
    }
}