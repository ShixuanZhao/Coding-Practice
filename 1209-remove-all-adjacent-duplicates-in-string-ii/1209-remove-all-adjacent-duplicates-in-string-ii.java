class Solution {
//     Use Stack(s) to save adjacent duplicate chars and the corresponding occurrences, pop them out when the occurrences reach k;
// Build String by the items remaining in Stack(s).
    class Node {
        char c;
        int cnt;
        Node(char c) {
            this.c = c;
            cnt = 1;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if (k > n) {
            return s;
        }
        Deque<Node> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || ch != stack.peekFirst().c) {
                stack.offerFirst(new Node(ch));
            } else {
                if (stack.peekFirst().cnt + 1 == k) {
                    stack.pollFirst();
                } else {
                    stack.peekFirst().cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            int times = node.cnt;
            for (int i = 0; i < times; i++) {
                sb.append(node.c);
            }
        }
        return sb.reverse().toString();
    }
}