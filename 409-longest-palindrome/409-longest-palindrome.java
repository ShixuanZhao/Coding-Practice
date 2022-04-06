class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //num of remove pairs
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                cnt++;
            } else {
                set.add(c);
            }
        }
        if (set.size() == 0) {
            return 2 * cnt;
        } else {
            //set.size() == 1
            return 2 * cnt + 1;
        }
        
    }
}