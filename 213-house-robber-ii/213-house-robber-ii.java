class Solution {
//     public int rob(int[] nums) {
//         //首位和最后一位至少有一个为主不抢
//         //case1:index0的位置不抢，rob(1, n - 1)
//         //case2:最后一位不抢,rob(0, n - 2)
//         int n = nums.length;
//         if (n == 1) {
//             return nums[0];
//         }
//         // if (n == 2) {
//         //     return Math.max(nums[0], nums[1]);
//         // }
//         return Math.max(rob(nums, 1, n - 1), rob(nums, 0, n - 2));
//     }
    
//     private int rob(int[] nums, int left, int right) {
//         int n = nums.length;
//         int[][] M = new int[n][2];
//         M[left][0] = 0;
//         M[left][1] = nums[left];
//         for (int i = left + 1; i <= right; i++) {
//             M[i][0] = Math.max(M[i - 1][0], M[i - 1][1]);
//             M[i][1] = M[i - 1][0] + nums[i]; 
//         }
//         return Math.max(M[right][0], M[right][1]);
//     }
    
     public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
         //case1: rob at index0 house and end at index n - 2
         //casea2: not rob the index0 house, start at index1, end at index n -1
         return Math.max(rob(nums, 2, n - 2) + nums[0], rob(nums, 1, n - 1));
     }
    
    private int rob(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }
}