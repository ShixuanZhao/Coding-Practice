class Solution {   
// Iterate the expression from tail, whenever encounter a character before '?', calculate the right value and push back to stack.
// P.S. this code is guaranteed only if "the given expression is valid" base on the requirement.(number is one-digit)
    // public String parseTernary(String expression) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     for (int i = expression.length() - 1; i >= 0; i--) {
    //         char c = expression.charAt(i);
    //         if (!stack.isEmpty() && stack.peekFirst() == '?') {
    //             //pop "?"
    //             stack.pollFirst();
    //             char a = stack.pollFirst();
    //             //pop ":"
    //             stack.pollFirst();
    //             char b = stack.pollFirst();
    //             if (c == 'T') {
    //                 stack.offerFirst(a);
    //             } else {
    //                 stack.offerFirst(b);
    //             }
    //         } else {
    //             stack.offerFirst(c);
    //         }
    //     }
    //     //convert char to string
    //     return String.valueOf(stack.peekFirst());
    // }
    
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
        
    }
    
    private char DFS(char[] exp, int left, int right) {
        if (left == right) {
            return exp[left];
        }
        //find the most outer layer ? :
        //最外层的 ? : pair,剩下的是子问题
        //the position of matched ':'
        int i = left;
        int cnt = 0;
        for (; i <= right; i++) {
            if (exp[i] == '?') {
                cnt++;
            } else if (exp[i] == ':') {
                cnt--;
                if (cnt == 0) {
                    break;
                }
            }
        }
        return exp[left] == 'T' ? DFS(exp, left + 2, i - 1) : DFS(exp, i + 1, right);
    }
}