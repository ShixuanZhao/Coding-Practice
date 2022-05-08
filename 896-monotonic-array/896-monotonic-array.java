class Solution {
    /*
    public boolean isMonotonic(int[] A) {
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                decrease = true;
            }
            if (A[i] > A[i - 1]) {
                increase = true;
            }
        }
        
        return increase && decrease ? false : true;
    }
    */
    public boolean isMonotonic(int[] nums) {
        //at first set true is i,portant
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDecreasing = false;
            }
            if (nums[i] < nums[i - 1]) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
    
    
}