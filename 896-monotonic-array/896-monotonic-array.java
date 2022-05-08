class Solution {
    /*
    nums = [1,2,2,3]
    nums = [1,4,2,3]
    isA:t
    isD:t
    is ==, we treat as ascending
    */
    public boolean isMonotonic(int[] nums) {
        boolean hasA = true;
        boolean hasD = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >  nums[i - 1]) {
                hasD = false;
            } 
           if (nums[i] <  nums[i - 1]) {
                hasA = false;
            } 
        }
        return hasD || hasA;
    }
}