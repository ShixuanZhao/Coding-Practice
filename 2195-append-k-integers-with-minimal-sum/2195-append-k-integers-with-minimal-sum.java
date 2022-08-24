class Solution {
    //TLE
    // public long minimalKSum(int[] nums, int k) {
    //     long sum = 0;
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         set.add(num);
    //     }
    //     int addNum = 1;
    //     while (k > 0) {
    //         if (!set.contains(addNum)) {
    //             set.add(addNum);
    //             sum += addNum;
    //             k--;
    //         }
    //         addNum++;
    //     }
    //     return sum;
    // }
    /*
    Sort and Track low missing bound and compute the arithmetic sequence.
Sort the input;
Starting from 1 as the lower bound of the missing range, then based on current num and k, 
determine current missing upper bound hi; Compute the subtotal in [lo, hi] and add it to ans.
    */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0, lo = 1;
        for (int num : nums) {
            if (num > lo) {
                long hi = Math.min(num - 1, lo + k - 1);
                int cnt = (int)(hi - lo + 1);
                ans += (lo + hi) * cnt / 2;
                k -= cnt;
                if (k == 0) {
                    return ans;
                }
            } 
            lo = num + 1;
        }
        if (k > 0) {
            ans += (lo + lo + k - 1) * k / 2;
        }
        return ans;
    }
    
}