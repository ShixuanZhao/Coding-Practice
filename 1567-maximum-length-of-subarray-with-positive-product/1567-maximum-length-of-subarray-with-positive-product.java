class Solution {
    /*
    split subarray by 0
    XX0XXKXX0XX
       i   j
       if [i, j] has even number of neg, len = j - i + 1
       else  move i to k + 1, k is the first apprearence index of neg number len = j - k 
    */
    public int getMaxLen(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            //number of negative number
            int cnt = 0;
            //first index of negative
            int firstIndex = -1;
            int j = i;
            for (; j < n && nums[j] != 0; j++) {
                if (firstIndex == -1 && nums[j] < 0) {
                    firstIndex = j;
                }
                if (nums[j] < 0) {
                    cnt++;
                }
                if (cnt % 2 == 0) {
                    res = Math.max(res, j - i + 1);
                } else {
                    res = Math.max(res, j - firstIndex);
                }
            }
            i = j;
        }
        return res;
    }
}