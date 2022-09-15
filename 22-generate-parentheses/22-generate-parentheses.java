class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        dfs(n, sb, 0, 0, 0, res);
        return res;
    }
    
    private void dfs(int n, StringBuilder sb, int index, int left, 
        int right, List<String> res) {
        if (index == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            dfs(n, sb, index + 1, left + 1, right, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(")");
            dfs(n, sb, index + 1, left, right + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}