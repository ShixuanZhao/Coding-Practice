class Solution {
    /*
        num = "1432219", k = 3
        stack相当于是一个缓存我们暂时还不确定在缓存里的元素要不要
        stack:1219
        k:3 2 1 0
    */
    public String removeKdigits(String num, int k) {
        //keep a ascending stack, at most delete k times
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peekFirst()) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(c);
        }
        //if still have k, we pop from tail
        while (k > 0) {
            stack.pollFirst();
            k--;
        }
        //corner case: leading zero, if stack is empty, return 0
        StringBuilder sb = new StringBuilder();
        boolean isLeading = true;
        while (!stack.isEmpty()) {
            //skip the leading zero
            //use another end of deque
            while (!stack.isEmpty() && stack.peekLast() == '0' && isLeading) {
                stack.pollLast();
            }
            isLeading = false;
            if (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}