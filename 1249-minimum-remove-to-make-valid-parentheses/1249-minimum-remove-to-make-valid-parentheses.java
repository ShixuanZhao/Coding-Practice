class Solution {
    /*
    1.traverse s from left to right, remove the extra ) 
    ())
    if we meet ), but the open == 0, we do not append this )
    2.traverse the result from 1 backward, remove the extra (
    ()(
    */
    public String minRemoveToMakeValid(String s) {
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
}