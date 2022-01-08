class Solution {
    /*
        s = "AABABBA", k = 1
             s
             f
        map: record the letter and its freq in window
        maxCnt:the most freq letter
        f:the cur letter
        s:move s when different letter > k
    */
    public int characterReplacement(String s, int k) {
        if (k >= s.length()) {
            return s.length();
        }
        int maxCnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int cnt1 = map.get(c);
            if (cnt1 > maxCnt) {
                maxCnt = cnt1;
            }
            while (i - slow + 1 - maxCnt > k) {
                char c1 = s.charAt(slow);
                map.put(c1, map.get(c1) - 1);
                slow++;
            }
            res = Math.max(res, i - slow + 1);
        }
        return res;
    }
}