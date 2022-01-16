class Solution {
    //i要全局的因为pointer从头走到黑，不存在backtracking。遇到右括号结果返回了但是pointer不动的
    int i = 0;
    public int calculate(String s) {
        //() -> recursion, basic calculator: stack
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            if (ch == '(') {
                num = calculate(s);
            }
            //be careful i == s.length() because we have already i++
            if (i == s.length() || ch == '+' || ch == '-' || ch == ')') {
                if (operator == '+') {
                    stack.push(num);
                } else {
                    stack.push(-num);
                }
                operator = ch;
                num = 0;
            }
            if (ch == ')') {
                //we jump out of the recursion                   
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}