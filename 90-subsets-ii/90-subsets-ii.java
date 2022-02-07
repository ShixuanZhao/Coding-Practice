class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        //a global var
        List<Integer> level = new LinkedList<>();
        helper(nums, level, 0, res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> level, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new LinkedList<Integer> (level));
            return;
        }
        level.add(nums[index]);
        helper(nums, level, index + 1, res);
        level.remove(level.size() - 1);
        //not add
        //if choose not add and we meet continuous duplicate element, we just skip this "level", only keep the first one
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper(nums, level, index + 1, res);
    }
}


//  public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> res = new LinkedList<>();
//         Arrays.sort(nums);
//         //a global var
//         List<Integer> level = new LinkedList<>();
//         helper(nums, level, 0, res);
//         return res;
//     }
    
//     private void helper(int[] nums, List<Integer> level, int index, List<List<Integer>> res) {
//         res.add(new LinkedList<Integer> (level));
//         for (int i = index; i < nums.length; i++) {
//             //skip the duplicate element, and only keep the first one
//             if (i != index && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             level.add(nums[i]);
//             helper(nums, level, i + 1, res);
//             level.remove(level.size() - 1);
//         }
//     }