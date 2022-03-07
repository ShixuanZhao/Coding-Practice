class Solution {
    /*
        0 1 2 
        1 2 2 
        l
            r
          m
    */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if(nums[mid] == nums[mid + 1]){
					left = mid;
				}else{
					right = mid;
				}
            } else {
                // similar logic as above
				if(nums[mid] == nums[mid - 1]){
					left = mid;
				}else{
					right = mid;
				}
            }
        }
        if (left != 0 && nums[left] == nums[left - 1] || left + 1 < n && nums[left] == nums[left + 1]) {
            return nums[right];
        } else {
            return nums[left];
        }
    }
}