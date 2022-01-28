class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordDict);
        StringBuilder sb = new StringBuilder();
        if (canBreak(s, dict)) {
            // System.out.println(1);
            dfs(s, dict, sb, 0, res);
        }
        return res;
    }
    
    private void dfs(String s, Set<String> dict, StringBuilder sb, int index, List<String> res) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            int len = sb.length();
            if (dict.contains(s.substring(index, i + 1))) {
                if (i != s.length() - 1) {
                    sb.append(s.substring(index, i + 1)).append(" ");
                    dfs(s, dict, sb, i + 1, res);
                } else {
                    sb.append(s.substring(index, i + 1));
                    dfs(s, dict, sb, i + 1, res);
                }
            }
            sb.setLength(len);
        }  
    }
    
    private boolean canBreak(String s, Set<String> dict) {
        boolean[] M = new boolean[s.length() + 1];
        M[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && dict.contains(s.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }
}