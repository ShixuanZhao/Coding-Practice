class Solution {
    // public int scoreOfParentheses(String s) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     stack.offerFirst(0); //the score of current layer
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             //初始化当前层的score
    //             stack.offerFirst(0);
    //         } else {
    //             //the score of cur layer, either (A) or ()
    //             //一个完整的（），当前层的score
    //             int m = stack.pollFirst();
    //             //上一层的score和当前成的score要相加
    //             int n = stack.pollFirst();
    //             //Math.max(1, 2 * m)区分case1和case3
    //             stack.offerFirst(n + Math.max(1, 2 * m));
    //         }
    //     }
    //     return stack.pollFirst();
    // }
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(score);
                score = 0;
            } else {
                score = stack.pollFirst() + Math.max(score * 2, 1);
            }
        }
        return score;
    }
}