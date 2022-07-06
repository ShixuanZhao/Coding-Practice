class Solution {
    /*
        num = "1432219", k = 3
        stack相当于是一个缓存我们暂时还不确定在缓存里的元素要不要
        stack:1219
        k:3 2 1 0
    */
    public String removeKdigits(String num, int k) {
        //生成最小递增序列，每次出现更小的时候我们就把前面更大的替换，可替换次数不超过k
        //ascending stack
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peekFirst()) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(c);
        }
        //如果k还有剩余，stack从后往前remove
        while (k > 0) {
            stack.pollFirst();
            k--;
        }
        //corner case 0200 remove the leading zero
        StringBuilder sb = new StringBuilder();
        //use a flag to represent the leading zero
        boolean flag = true;
        //this is a deque, this time we operate the other end of deque
        while (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peekLast() == '0' && flag) {
                stack.pollLast();
            } 
            flag = false;
            if (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}