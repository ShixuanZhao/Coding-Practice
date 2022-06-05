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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int j = i;
            //the index of first neg
            int neg = -1;
            //the number of neg in [i, j]
            int cnt = 0;
            while (j < nums.length && nums[j] != 0) {
                if (neg == -1 && nums[j] < 0) {
                    neg = j;
                }
                if (nums[j] < 0) {
                    cnt++;
                }
                if (cnt % 2 == 0) {
                    res = Math.max(res, j - i + 1);
                } else {
                    res = Math.max(res, j - neg);
                }
                j++;
            }
            i = j;
        }
        return res;
    }
}