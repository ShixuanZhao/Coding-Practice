class Solution {
    //must use map instead of map because set will remove all letter in the window
    // public int lengthOfLongestSubstringKDistinct(String s, int k) {
    //     int res = 0;
    //     Set<Character> set = new HashSet<>();
    //     int left = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         set.add(c);
    //         while (set.size() > k) {
    //             set.remove(s.charAt(i));
    //             i++;
    //         }
    //         res = Math.max(res, i - left + 1);
    //     }
    //     return res;
    // }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char c1 = s.charAt(left);
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    map.remove(c1);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}