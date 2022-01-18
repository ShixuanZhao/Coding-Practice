class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isPossible(int[] houses, int[] heaters, int r) {
        int m = houses.length;
        int n = heaters.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int left = heaters[i] - r;
            int right = heaters[i] + r;
            while (index < m && houses[index] >= left && houses[index] <= right) {
                index++;
            }
            if (index == m) {
                return true;
            }
        }
        return false;
    }
}