class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        return dfs(pattern, s, 0, 0, map1, map2);
    }
    
    private boolean dfs(String pattern, String s, int index1, int index2,
                       Map<Character, String> map1, Map<String, Character> map2) {
        if (index1 == pattern.length() || index2 == s.length()) {
            if (index1 == pattern.length() && index2 == s.length()) {
                return true;
            }
            return false;
        }
        for (int i = index2; i < s.length(); i++) {
            String cur = s.substring(index2, i + 1);
            char c = pattern.charAt(index1);
            if (!map1.containsKey(c)) {
                if (map2.containsKey(cur)) {
                    continue;
                }
                //map1 map2同步更新，所以要是要么两个都有，要么两个都没有才对
                map1.put(c, cur);
                map2.put(cur, c);
                if (dfs(pattern, s, index1 + 1, i + 1, map1, map2)) {
                    return true;
                }
                map1.remove(c);
                map2.remove(cur);
            } else {
                if (!map1.get(c).equals(cur)) {
                    continue;
                }
                if (dfs(pattern, s, index1 + 1, i + 1, map1, map2)) {
                    return true;
                }
            }
        }
        return false;
    }
}