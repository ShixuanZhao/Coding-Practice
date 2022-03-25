class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestTime = releaseTimes[0];
        char longestKey = keysPressed.charAt(0);
        int n = keysPressed.length();
        for (int i = 1; i < n; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > longestTime || diff == longestTime && keysPressed.charAt(i) > longestKey) {
                longestTime = diff;
                longestKey = keysPressed.charAt(i);
            }
        }
        return longestKey;
    }
}