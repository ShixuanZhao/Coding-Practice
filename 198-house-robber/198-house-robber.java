class Solution {
    public int rob(int[] nums) {
        int[][] M = new int[nums.length][2];
        //0不抢， 1抢
        M[0][0] = 0;
        M[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            M[i][0] = Math.max(M[i - 1][0], M[i - 1][1]);
            M[i][1] = M[i - 1][0] + nums[i];
        }
        return Math.max(M[nums.length - 1][0], M[nums.length - 1][1]);
    }
}