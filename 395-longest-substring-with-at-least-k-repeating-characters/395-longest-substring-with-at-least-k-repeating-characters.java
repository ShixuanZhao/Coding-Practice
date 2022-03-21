class Solution {
    // In each step, just find the infrequent elements (show less than k times) as splits since any of these infrequent elements couldn't be any part of the substring we want.
    public int longestSubstring(String s, int k) {
         if (k > s.length()) {
             return 0;
         }
        int n = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int res = 0;
        //find the infrequent ele, and split s
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] < k) {
                for (String sub : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(sub, k));
                }
                return res;
            }
        }
        return n;
    }
}