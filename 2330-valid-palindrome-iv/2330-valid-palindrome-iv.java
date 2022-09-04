class Solution {
    public boolean makePalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (++cnt > 2) {
                    return false;
                }
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}