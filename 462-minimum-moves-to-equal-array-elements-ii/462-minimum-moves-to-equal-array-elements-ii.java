class Solution {
    /*
    [1,10,2,9]
    1 2 9 10
    */
    public int minMoves2 (int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        Arrays.sort (nums);
        int mid = n/2;
        int count = 0;
        for (int i = 0; i < n; i++)
            count += (Math.abs (nums [i] - nums [mid]));
        return count;
    }
}