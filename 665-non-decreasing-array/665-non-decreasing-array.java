class Solution {
    /*          
    case1:2 4 2 6
              i    change i -1 to i  2 2 2 6
    case2:3 4 2 6
              i      change i to i - 1     3 4 4 6
    */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}