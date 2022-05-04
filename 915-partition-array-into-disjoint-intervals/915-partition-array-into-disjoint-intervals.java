class Solution {
    /*
    enumerate each i from 0 to n - 2  left:[0, left] right:[left + 1, n - 1]
    check is valid: max of left is small or euqal to the min of right
    O(n^2)
    [5,0,3,8,6]
    i
             j
    max of left:  5 5 5 8 8
    min of right: 0 0 3 6 6
    
    */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int prevMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max[i] = Math.max(prevMax, nums[i]);
            prevMax = max[i];
        }
        int prevMin = Integer.MAX_VALUE;
        int[] min = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(prevMin, nums[i]);
            prevMin = min[i];
        }
        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return n;
    }
}