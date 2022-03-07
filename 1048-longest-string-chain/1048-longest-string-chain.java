class Solution {
    public int longestStrChain(String[] words) {
    Arrays.sort(words, (a, b) -> (a.length() - b.length()));
    int[] dp = new int[words.length];
    int maxLen = 0;
    for (int i = 0; i < words.length; i++) {
        dp[i] = 1;
        for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
            if (isPredecessor(words[j], words[i])) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
}

 private boolean isPredecessor(String s1, String s2) {
    if (s2.length() == s1.length()) return false;
    int diff = 0;
    for (int i = 0, j = 0; i < s1.length(); ) {
        if (s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else {
            diff++;
            if (diff > 1) return false;
            j++;
        }
    }
    return true;
}
}