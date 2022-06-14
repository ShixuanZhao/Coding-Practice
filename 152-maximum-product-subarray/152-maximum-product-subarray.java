class Solution {
    //如果要求给出boundry，记录snapshot when update the globalMax
    public int maxProduct(int[] nums) {
        //母题：max subarray sum
         if(nums.length == 0)
            return 0;
        int ans = nums[0];
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积；
        //因为nums[i]可能是正的或负的，我需要看linear scan前一个
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP；
        maxDP[0] = nums[0]; minDP[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            //最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
            //与i元素自己进行比较是为了处理i元素之前全都是0的情况；
           if (nums[i] > 0) {
               maxDP[i] = Math.max(nums[i], nums[i] * maxDP[i - 1]);
               minDP[i] = Math.min(nums[i], nums[i] * minDP[i - 1]);
           } else {
               maxDP[i] = Math.max(nums[i], nums[i] * minDP[i - 1]);
               minDP[i] = Math.min(nums[i], nums[i] * maxDP[i - 1]);
           }
            //记录ans；
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    
    }
    //max[i]:the largest product of the subarray within the range of [0,i] (including the i-th element)
    //max[i] = Math.max(a[i], Math.max(max[i - 1] * a[i], min[i - 1] * a[i]))
    //min[i].....
    //use two var
//     public int maxProduct(int[] nums) {
        
//         int max = nums[0], min = nums[0], ans = nums[0];
        
//         for (int i = 1; i < nums.length; i++) {
            
//             int temp = max;  // store the max because before updating min your max will already be updated
            
//             max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
//             min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            
//             if (max > ans) {
//                 ans = max;
//             }
//         }
        
//         return ans;

//     }
}