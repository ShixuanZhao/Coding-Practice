class Solution {
    /*
    [2,6,4,8,10,9,15]
     2 4 6 8 9 10 15
    */
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = nums.length - 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start > 0 ? end - start + 1 : 0;
    }
}