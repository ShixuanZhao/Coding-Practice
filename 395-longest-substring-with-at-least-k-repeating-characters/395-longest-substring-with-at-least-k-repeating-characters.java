class Solution {
    // In each step, just find the infrequent elements (show less than k times) as splits since any of these infrequent elements couldn't be any part of the substring we want.
    /*
    不能用滑动窗口，滑动窗口的条件是fast move到有效到无效，无效的时候move slow再到有效
    bbaaa  k = 3但是这个例子不好区分什么时候有效什么时候无效
    所以先统计那些invalid letter（答案中不包括的），再把他们作为分割点，recursion
    */
    public int longestSubstring(String s, int k) {
         if (k > s.length()) {
             return 0;
         }
        int n = s.length();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] < k) {
                String sub1 = s.substring(0, i);
                String sub2 = s.substring(i + 1);
                return Math.max(longestSubstring(sub1, k), longestSubstring(sub2, k));
            }
        }
        return n;
    }
}