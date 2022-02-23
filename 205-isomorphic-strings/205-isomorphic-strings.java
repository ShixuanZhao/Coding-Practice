class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (sTot.containsKey(s1) && sTot.get(s1) != t1) {
                return false;
            }
            if (tTos.containsKey(t1) && tTos.get(t1) != s1) {
                return false;
            }
            sTot.put(s1, t1);
            tTos.put(t1, s1);
        }
        return true;
    }
}