class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //古城算法经典考题6，括号下
        //brute force, hashset to avoid duplicate
        //number of "(" we need to remove
        int rmL = 0;
        int rmR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rmL++;
            } else if (c == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, rmL, rmR, 0, set, sb);
        return new ArrayList<>(set);
    }
    
    private void dfs(String s, int i, int rmL, int rmR, int open, Set<String> set, StringBuilder sb) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            //delete
            dfs(s, i + 1, rmL - 1, rmR, open, set, sb);
            //not delete, append
            dfs(s, i + 1, rmL, rmR, open + 1, set, sb.append(c));
        } else if (c == ')') {
            //delete
            dfs(s, i + 1, rmL, rmR - 1, open, set, sb);
            //not delete, append
            dfs(s, i + 1, rmL, rmR, open - 1, set, sb.append(c));
        } else {
            //add letter anyway
            dfs(s, i + 1, rmL, rmR, open, set, sb.append(c));
        }
        sb.setLength(len);
    }
}