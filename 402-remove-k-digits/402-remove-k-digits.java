class Solution {
    /*
    the length between num and k
    0000  00034 k = 1 return 0 return 3
    Use a stack, keep a increasing stack 
    "1432219", k = 3
          i
    stack:1219
    k:0
    if, k > 0, after go through the string
    remove ele from backward
    remove the leading zero
    corner case: after remove the leading zero, stack is empty, return "0"
    stack相当于是一个缓存我们暂时还不确定在缓存里的元素要不要
    */
    public String removeKdigits(String num, int k) {
        //suppose k <= num.length()
        if (num == null || num.length() == 0) {
            return "";
        }
        int n = num.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peekFirst()) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(num.charAt(i));
        }
        //remove ele from backward
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pollFirst();
        }
        //remove the leading zero, so remove from Last side of stack
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}