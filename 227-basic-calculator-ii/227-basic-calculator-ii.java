class Solution {
    /*
        ds: stack 
        s = "3+2*2"
                 i
        op:*
        stack:3 4
        num:2
        2 * num(2) = 4
        3 + 4 = 7
        return 7
    */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            //can not be else if because we want to excute i == s.length() - 1
           if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
               if (operator == '+') {
                   stack.offerFirst(num);
               }
               if (operator == '-') {
                   stack.offerFirst(-num);
               }
               if (operator == '*') {
                   stack.offerFirst(stack.pollFirst() * num);
               }
               if (operator == '/') {
                   stack.offerFirst(stack.pollFirst() / num);
               }
               num = 0;
               operator = c;
           }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollFirst();
        }
        return res;
        
    }
}