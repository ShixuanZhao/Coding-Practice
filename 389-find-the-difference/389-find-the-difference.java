class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c -'a']--;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']++;
        }
        int i = 0;
        for (; i < 26; i++) {
            if (freq[i] == 1) {
                break;
            }
        }
        return (char)(i + 'a');
    }
}