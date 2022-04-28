class Solution {
    /*
          root(i = 0) i is the start pos
       a    aa   aab(is not pali)
     a ab   b
    */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        dfs(res, cur, 0, s);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> cur, int index, String s) {
        if (index == s.length()) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isP(s, index, i)) {
                cur.add(s.substring(index, i + 1));
                dfs(res, cur, i + 1, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isP(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}