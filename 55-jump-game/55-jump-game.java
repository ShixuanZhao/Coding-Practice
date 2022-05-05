class Solution {
    /*
    M[i] whether we can jump from index0 to index i 
    M[i] = true if we can find a index j(j < i) M[j] = true && j + nums[j] >= i
    else = false
    M[0] = true;
    */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] M = new boolean[n];
        M[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && j + nums[j] >= i) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[n - 1];
    }
}