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
    
    // public char findTheDifference(String s, String t) {
    //     char c = 0;
    //     for(int i = 0; i < s.length(); i++){
    //         c ^= s.charAt(i);
    //     }
    //     for(int i = 0; i < t.length(); i++){
    //         c ^= t.charAt(i);
    //     }
    //     return c;
    // }
}