class Solution {
    public String minRemoveToMakeValid(String s) {
        //store the index of () to be removed(invalid)
        Set<Integer> indexToRemove = new HashSet<>();
        //store the index of () '(' push ')' pop
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerFirst(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pollFirst();
                }
            }
        }
        //if there are element in the stack, it would be unmatched '('
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pollFirst());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}