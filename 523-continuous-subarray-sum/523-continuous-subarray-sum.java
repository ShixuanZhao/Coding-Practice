class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //2 sum, sum = sum % k
        // 相同余数出现，之间的subarray是可以被k整除的
        int sum = 0;
        //map: key remainder value: index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //corner case: k != 0 %的时候注意，除数不能是0
            if (k != 0) {
                sum %= k;
            }
            //prefixSum:[0, i] subarray sum: (i, j]
            if (map.containsKey(sum)) {
                if (i - (map.get(sum) + 1) >= 1) {
                    return true;
                } 
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}