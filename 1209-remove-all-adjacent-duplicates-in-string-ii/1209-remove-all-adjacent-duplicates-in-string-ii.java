class Solution {
    class Node {
        char c;
        int cnt;
        public Node(char c) {
            this.c = c;
            cnt = 1;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peekFirst().c != c) {
                stack.offerFirst(new Node(c));
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
            Node cur = stack.pollFirst();
            char c = cur.c;
            int cnt = cur.cnt;
            for (int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}