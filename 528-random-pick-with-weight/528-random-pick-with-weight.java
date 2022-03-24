class Solution {
    //use accumulated sum(including the boundary) fto get index
    /*
    w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
then get random val random.nextInt(14)+1, idx is in range [1,14]
idx in [1,2] return 0
idx in [3,7] return 1
idx in [8,10] return 2
idx in [11,14] return 3
then become LeetCode 35. Search Insert Position
Time: O(n) to init, O(logn) for one pick
Space: O(n)
    */
    Random random;
    int[] wSum;
    
    public Solution(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.wSum = w;
    }
    
    public int pickIndex() {
        int len = wSum.length;
        int idx = random.nextInt(wSum[len-1]) + 1;
        int left = 0;
        int right = len - 1;
        if (wSum[left] == idx) {
            return left;
        }
        if (wSum[right] == idx) {
            return right;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (idx < wSum[mid]) {
                right = mid;
            } else if (idx == wSum[mid]) {
                return mid;
            } else {
                left = mid;
            }
        }
        if (wSum[left] < idx && idx < wSum[right]) {
            return right;
        } else if (idx < wSum[left]) {
            return left;
        } else {
            return right + 1;
        }    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */