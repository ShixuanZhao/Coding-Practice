class Solution {
    /*
    1 3 2 5 4  -> 1 3 4 5 2 -> 1 3 4 2 5
        i    j        i    j
    step1: find i: scan from right to left, the first non-increasing element
    step2: find j: scan from right to left, the smallest element that is larger than i
    step3:swap(i, j)
    step4: reverse from i + 1 to end
    */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //321 -> 123
        if (i == -1) {
            reverse(nums, 0);
        } else {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
                //System.out.println(j);
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
        }
        
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void reverse(int[] array, int start) {
        int left = start;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
    }
}