class Solution {
    //M[i] whether can reach last position from index i
    public boolean canJump(int[] nums) {
//         //make a diff from leetcode746
//         if (nums.length == 1) {
//             return true;
//         }
//         int n = nums.length;
//         boolean[] M = new boolean[n];
//         M[n - 1] = true;
//         for (int i = n - 2; i >= 0; i--) {
//             if (i + nums[i] >= n - 1) {
//                 M[i] = true;
//             } else {
//                 for (int j = 1; j <= nums[i]; j++) {
//                     if (M[i + j]) {
//                         M[i] = true;
//                         break;
//                     }
//                 }
//             }
//         }
//         return M[0];
        
        //M2:much slower
    //M[i] whether index i is reachable from index0
        if (nums.length == 1) {
            return true;
        }
        int n = nums.length;
        boolean[] M = new boolean[n];
        M[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (M[j] && j + nums[j] >= i) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[n - 1];
    }
}