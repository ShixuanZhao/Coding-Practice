class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerFirst(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pollFirst();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pollFirst());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}