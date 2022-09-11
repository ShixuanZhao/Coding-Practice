class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(s, 0, set);
    }
    
    //the number of unique substring for the s[index, end]
    //global hashset
    private int dfs(String s, int index, Set<String> set) {
        //empty string
        if (index >= s.length()) {
            return 0;
        }
        int res = -1;
        //i the end index, substring [index, i)
        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);
            if (set.contains(cur)) {
                continue;
            }
            set.add(cur);
            int sub = dfs(s, i, set);
            //must >= 0 not > 0
            //consider for the corner case
            //when oen letter, we should return 1
            if (sub >= 0) {
                res = Math.max(res, sub + 1);
            }
            set.remove(cur);
        }
        return res;
    }
    
}