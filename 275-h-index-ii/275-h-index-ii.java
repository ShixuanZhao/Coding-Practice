class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        if (citations.length == 1) return citations[0] == 0 ? 0 : 1;
        int left = 0;
        int right = citations.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (possible(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return possible(citations, right) == true ? right : left;
    }
    
    private boolean possible(int[] citations, int mid) {
        int cnt = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= mid) {
                cnt = citations.length - i;
                break;
            }
        }
        return cnt >= mid ? true : false;
    }
}