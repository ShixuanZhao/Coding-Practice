class Solution {
    /*
    M[i] whether we can jump from index0 to index i 
    M[i] = true if we can find a index j(j < i) M[j] = true && j + nums[j] >= i
    else = false
    M[0] = true;
    */
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     boolean[] M = new boolean[n];
    //     M[0] = true;
    //     for (int i = 1; i < n; i++) {
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (M[j] && j + nums[j] >= i) {
    //                 M[i] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return M[n - 1];
    // }
    
    //greedy,如果当前index可以到达，我们就更新更远的可以到达的位置
    public boolean canJump(int[] nums) {
        //the max index we can reach locally
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1;
    }
    
    
    
    
    
    //M[i] whether can reach last position from index i
    // public boolean canJump(int[] nums) {
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
}