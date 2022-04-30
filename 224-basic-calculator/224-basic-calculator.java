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
    //i要全局的因为pointer从头走到黑，不存在backtracking。遇到右括号结果返回了但是pointer不动的
    int i = 0;
    public int calculate(String s) {
       //  Deque<Integer> stack = new ArrayDeque<>();
       //  int sign = 1;
       //  int num = 0;
       //  while (i < s.length()) {
       //      char c = s.charAt(i++);
       //      if (c >= '0' && c <= '9') {
       //          num = num * 10 + (c - '0');
       //      }  
       //      //must be put here before line31
       //      if (c == '(') {
       //          num = calculate(s);
       //      } 
       //      //must be if, not if. because otherwise i == s.length would not be excuted
       //      if (c == '+' || c == '-' || i == s.length() || c == ')') {
       //          stack.push(sign * num);
       //          if (c == '+') {
       //              sign = 1;
       //          } else if (c == '-') {
       //              sign = -1;
       //          }
       //          num = 0;
       //      }  
       //      if (c == ')') {
       //          break;
       //      }
       //  }
       //  int res = 0;
       // // System.out.println(stack.size());
       //  while (!stack.isEmpty()) {
       //      System.out.println(stack.peek());
       //      res += stack.poll();
       //  }
       //  return res;
        
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