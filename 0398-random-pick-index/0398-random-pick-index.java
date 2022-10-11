class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) count++;
        }
        //choose the pickIndex-th number
        int pickIndex = rand.nextInt(count);
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                if(pickIndex-- == 0) return i;
            }
        }
        return 0; // shouldn't come here
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */