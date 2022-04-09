class Solution {
    public int longestConsecutive(int[] nums) {
        //算法的关键：找出连续序列的的起点，设起点为x，看x+1,x+2...
        //怎么筛选起点？如果在set里有x-1，那可以忽略，因为他肯定不是起点
        //每个element遍历一遍，判断在不在set是O（1），总的T=O（n）
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        int globalMax = 1;
        for (int i = 0; i < nums.length; i++) {
            //说明是起点
            int curMax = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(++nums[i])) {
                    curMax++;
                }
            globalMax = Math.max(globalMax, curMax);    
            }           
        }
        return globalMax;
    }
}