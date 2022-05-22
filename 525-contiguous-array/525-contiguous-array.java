class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        //this is a trick let 0 become -1, so we will check sum == 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        //not need to partition, the whole array[0, i] is a valid ans
        //key is the prefixSum, val is the left index
        map.put(0, -1);
        //sum:the sum between[0, i]
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                //because maxLen, so we updata the map only first time
                 map.put(sum, i);
            }
           
        }
        return res;
    }
}