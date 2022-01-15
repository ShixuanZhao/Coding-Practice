class Solution {
    /*
        high level: maintain a sliding window [left, right] that contain every letter in t, calculate the min size 
        we need a hapmap to record all the letter in t and its frequent, that is what we want to matched in the sw
        map: key: A B C
             val: 1 1 1
        step1:construct the freqMap
        step2:traverse
        keep move right until all the letter in map have been matched
        and then move left to shrink size
        Input: s = "ADOBECODEBANC", t = "ABC"
                    l
                         r
    */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        //freqMap, we should match
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        //the number of character that we have already matched
        int match = 0;
        int minBegin = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (map.containsKey(c1)) {
                int cnt1 = map.get(c1);
                map.put(c1, --cnt1);
                if (cnt1 == 0) {
                    match++;
                }
            }
            while (match == map.size()) {
                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minBegin = left;
                }
                char c2 = s.charAt(left);
                if (map.containsKey(c2)) {
                    int cnt2 = map.get(c2);
                    map.put(c2, ++cnt2);
                    if (cnt2 == 1) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minBegin, minBegin + minLen);
    }
}