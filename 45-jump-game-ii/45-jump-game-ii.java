class Solution {
    /*   0  1  2 3    index
        [2, 3 ,1,1,4]
               i
         j
         
         left part: how to jump to index j(last position we jump to), j + nums[j] >= i && we can get to index j
         right part: from index j, we just need to jump 1 step in order to get index i 
         M[i] = Math.min(M[j] + 1, M[i]) nums[j] + j >= i for each valid j
         
              0 1 2 3 4
        M[i]: 0 1 1 2 2 
        min(1, 2)
        
        //dp
        M[i]:the min jump from index 0 to index i
        initialize each element would be Integer.MAX_VALUE
        M[i] = Math.min(M[j] + 1, M[i]) nums[j] + j >= i also: we can get to index j from begining, M[j] != MaxValue
    */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] M = new int[n];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] != Integer.MAX_VALUE && nums[j] + j >= i) {
                    M[i] = Math.min(M[j] + 1, M[i]);
                }
            }
        }
        return M[n - 1];
    }
}