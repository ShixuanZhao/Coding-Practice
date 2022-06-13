class Solution {
    // public int rob(int[] nums) {
    //     int[][] M = new int[nums.length][2];
    //     //0不抢， 1抢
    //     M[0][0] = 0;
    //     M[0][1] = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         M[i][0] = Math.max(M[i - 1][0], M[i - 1][1]);
    //         M[i][1] = M[i - 1][0] + nums[i];
    //     }
    //     return Math.max(M[nums.length - 1][0], M[nums.length - 1][1]);
    // }
    
    /*
    base case:M[0] = nums[0] M[1] = Math.max(M[0], nums[1])
    M[i] = max(M[i - 2] + nums[i](rob), M[i - 1](not rob))
    */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //linear scan two previous variable
        int temp1 = nums[0];
        int temp2 = Math.max(temp1, nums[1]);
        int res = temp2;
        //i is the index of house
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(temp1 + nums[i], temp2);
            temp1 = temp2;
            temp2 = res;
        }
        return res;
    }
}