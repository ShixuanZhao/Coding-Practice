class Solution {   
// Iterate the expression from tail, whenever encounter a character before '?', calculate the right value and push back to stack.
// P.S. this code is guaranteed only if "the given expression is valid" base on the requirement.(number is one-digit)
    public String parseTernary(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peekFirst() == '?') {
                //pop "?"
                stack.pollFirst();
                char a = stack.pollFirst();
                //pop ":"
                stack.pollFirst();
                char b = stack.pollFirst();
                if (c == 'T') {
                    stack.offerFirst(a);
                } else {
                    stack.offerFirst(b);
                }
            } else {
                stack.offerFirst(c);
            }
        }
        //convert char to string
        return String.valueOf(stack.peekFirst());
    }
}