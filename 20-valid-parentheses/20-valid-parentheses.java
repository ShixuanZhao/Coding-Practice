class Solution {
    /*
        { [ ) }
            i
        stack:} ] 
    */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peekFirst() == c) {
                        stack.pollFirst();
                    } else {
                        return false;
                    }
                }
            }
        }
        //find whether all the open paranthes has been matched
        return stack.isEmpty();
    }
}