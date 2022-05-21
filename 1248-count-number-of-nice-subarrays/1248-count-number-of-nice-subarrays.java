class Solution {
    //exactly k
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    //the number of subarray which has at most k odd num
    public int atMost(int[] A, int k) {
        int res = 0;
        int n = A.length;
        int odd = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                odd++;
            }
            while (odd > k) {
                if (A[i] % 2 == 1) {
                    odd--;
                }
                i++;
            }
            //length of window
            res += j - i + 1;
        }
        return res;
    }
}