class Solution {
    /*
    if A[i] < A[j] i++
    else j--
    [1,8,6,2,5,4,8,3,7]
     i
                     j
    
    */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            //we move the lower bound, because we maybe can get higher height, which could get greater res
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}