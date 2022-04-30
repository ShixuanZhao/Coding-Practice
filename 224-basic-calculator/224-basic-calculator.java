class Solution {
    /*
    if no ():
    2-1 + 2
    i
    case1:number record the num
    case2:sign push sign*num into the stack
    sign:+
    cur num:2
    stack:2,-1,+2
    calculate the final res
    if with ()
    case1:( call recursion
    case2:) calculate the res in the stack and return 
    */
    int i = 0;
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }  
            if (c == '(') {
                num = calculate(s);
            } 
            //must be if, not if. because otherwise i == s.length would not be excuted
            if (c == '+' || c == '-' || i == s.length() || c == ')') {
                stack.push(sign * num);
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
                num = 0;
            } 
           
            if (c == ')') {
                break;
            }
        }
        int res = 0;
       // System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            res += stack.poll();
        }
        return res;
    }
}