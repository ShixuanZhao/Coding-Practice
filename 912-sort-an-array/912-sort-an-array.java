class Solution {
    public int[] sortArray(int[] nums) {
        //quick sort
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = findPos(nums, left, right);
        quickSort(nums, left, pos - 1);
        quickSort(nums, pos + 1, right);
    }
    
    private int findPos(int[] nums, int left, int right) {
        int pivot = right;
        int val = nums[pivot];
        int i = left;
        int j = pivot - 1;
        while (i <= j) {
            if (nums[i] <= val) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, pivot);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}