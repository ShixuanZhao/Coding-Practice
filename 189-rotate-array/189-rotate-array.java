class Solution {
    /*
        1234   567
        567    1234
        两个单词交换顺序但是内部顺序不变
            A1      A2
        [1,2,3,4,|5,6,7], k = 3
         4 3 2 1  7 6 5       
         5 6 7  1   2   3  4
         step1:reverse subarray a1 and a2
         step2:reverse the whole sentence
    */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    //reverse the array in place from left to right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}