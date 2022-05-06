class Solution {
    int[] wSum;
    Random random;
    public Solution(int[] w) {
        int n = w.length;
        wSum = new int[n];
        random = new Random();
        for (int i = 1; i < n; i++) {
            w[i] += w[i - 1]; 
        }
        this.wSum = w;
    }
    
    //find the insert index in the sorted array
    //[2, 5, 8] insert 6, return 2
    public int pickIndex() {
        //generate a val from 1 to w[w.length - 1]
        int t = random.nextInt(0, wSum[wSum.length - 1]) + 1;
        int left = 0;
        int right = wSum.length - 1;
        // if (wSum[left] == t) {
        //     return left;
        // }
        // if (wSum[right] == t) {
        //     return right;
        // }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (wSum[mid] == t) {
                return mid;
            } else if (wSum[mid] < t) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //  2 4
        //1
        //   3
        //       7
        if (wSum[left] >= t) {
            return left;
        } else if (t > wSum[left] && t <= wSum[right]) {
            return right;
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