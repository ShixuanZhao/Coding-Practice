class Solution {
    //Count chars of both text and balloon and find the minimum of the times of the count of chars of text / balloon.
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        int[] cntBallon = new int[26];
        for (int i = 0; i < text.length(); ++i)
            ++cnt[text.charAt(i) - 'a'];
        int min = text.length();
        for (char c : "balloon".toCharArray())
            ++cntBallon[c - 'a'];
        for (char c : "balloon".toCharArray()) {
            min = Math.min(min, cnt[c - 'a'] / cntBallon[c - 'a']);
        }
        return min;
    }
}