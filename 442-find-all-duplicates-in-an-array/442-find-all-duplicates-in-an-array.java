class Solution {
    /*
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
     0 1 2
    [1,-1,2]
    res:1
       0 1 2 
      [1,2,1]
    */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            //说明之前已经有人对应过index位置上的元素了， < 0
            if (nums[index] < 0) {
                res.add(Math.abs(num));
            }
            //负号标记被对应的元素
            nums[index] = -nums[index];
        }
        return res;
    }
    //must use set因为在一直交换的过程中会重复加入重复的数，最好的方法是不交换，把num[i] - 1对应位置的值变为负数，表示visited过了
//     public List<Integer> findDuplicates(int[] nums) {
//       Set<Integer> set = new HashSet<>();
//       for (int i = 0; i < nums.length; i++) {
//             while (i != nums[i] - 1) {
//                 //must be break not continue
//                 if (nums[i] == nums[nums[i] - 1]) {
//                     set.add(nums[i]);
//                     break;
//                 }
//                 swap(nums, i, nums[i] - 1);
//             }
//         }
//         return new ArrayList<>(set);
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
}