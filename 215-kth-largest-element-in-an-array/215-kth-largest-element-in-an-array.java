class Solution {
    /*
    int index = partition(nums, left, right)
    k is the k-th smallest index
    if index == k return
    if index < k left = index + 1
    else right = index - 1
    */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        //target index
        int target = n - k;
        int left = 0;
        int right = n - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }
    
    /*
    3,2,1,4,6,5
          i       
        j
    */
    private int partition(int[] nums, int left, int right) {
        //pivot index and val
        int index = right;
        int val = nums[index];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] < val) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, index);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}