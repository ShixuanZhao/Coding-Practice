class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
  			return false;
        }
        Map<Character, String> pts = new HashMap();
        Map<String, Character> stp = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            char p1 = pattern.charAt(i);
            String s1 = words[i];
            if (pts.containsKey(p1) && !pts.get(p1).equals(s1)) {
                return false;
            }
            if (stp.containsKey(s1) && stp.get(s1) != p1) {
                return false;
            }
            pts.put(p1, s1);
            stp.put(s1, p1);
        }
        return true;
    }
}