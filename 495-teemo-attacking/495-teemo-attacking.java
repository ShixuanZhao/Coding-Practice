class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int res = duration * n;
        for (int i = 1; i < n; i++) {
            if (timeSeries[i - 1] + duration > timeSeries[i]) {
                res -= timeSeries[i - 1] + duration - timeSeries[i];
            }
        }
        return res;
    }
}