class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                stack1.offerFirst(c);
            } else {
                stack1.pollFirst();
            }
        }
        for (char c : t.toCharArray()) {
            if (Character.isLetter(c)) {
                stack2.offerFirst(c);
            } else {
                stack2.pollFirst();
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty()) {
            if (stack1.pollFirst() != stack2.pollFirst()) {
                return false;
            }
        }
        return true;
    }
}