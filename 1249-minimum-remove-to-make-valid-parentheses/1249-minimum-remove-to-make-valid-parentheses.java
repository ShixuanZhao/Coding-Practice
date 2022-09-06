class Solution {
    /*
    1.traverse s from left to right, remove the extra ) 
    ())
    if we meet ), but the open == 0, we do not append this )
    2.traverse the result from 1 backward, remove the extra (
    ()(
    make diff with 921. Minimum Add to Make Parentheses Valid
    */
    public String minRemoveToMakeValid(String s) {
        //open left (
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }
        //System.out.println(sb.toString());
        StringBuilder res = new StringBuilder();
        //traverse sb backward
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) {
                continue;
            }
            res.append(sb.charAt(i));
        }
        return res.reverse().toString();
    }
    
    //intuition
    // public String minRemoveToMakeValid(String s) {
    //     Set<Integer> indexesToRemove = new HashSet<>();
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') {
    //             stack.push(i);
    //         } if (s.charAt(i) == ')') {
    //             if (stack.isEmpty()) {
    //                 indexesToRemove.add(i);
    //             } else {
    //                 stack.pop();
    //             }
    //         }
    //     }
    //     // Put any indexes remaining on stack into the set.
    //     while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (!indexesToRemove.contains(i)) {
    //             sb.append(s.charAt(i));
    //         }
    //     }
    //     return sb.toString();
    // }
}