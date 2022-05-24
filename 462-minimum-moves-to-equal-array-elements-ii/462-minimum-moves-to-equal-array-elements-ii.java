class Solution {
    /*
    排序之后2 2配对，任何一个数在两个数之间滑动，距离是一样的，然后再往里面的2个pair
    找中位数（最优解是快排） O(n)
    */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }
}