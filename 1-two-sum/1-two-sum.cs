public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        if (nums.Length < 2) {
            return new int[2];
        }
        Dictionary<int, int> dict = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++) {
            if (dict.ContainsKey(target - nums[i])) {
                return new int[] {i, dict[target - nums[i]]};
            }
            if (!dict.ContainsKey(nums[i])) {
                dict.Add(nums[i], i);
            }
        }
        return null;
    }
}