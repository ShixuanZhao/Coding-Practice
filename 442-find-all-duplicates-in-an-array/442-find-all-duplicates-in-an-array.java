class Solution {
    /*
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
     0 1 2
    [-1,-2,2]
    res:1
       0 1 2 
      [1,2,1]
    */
    public List<Integer> findDuplicates(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                //must be break not continue
                if (nums[i] == nums[nums[i] - 1]) {
                    set.add(nums[i]);
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return new ArrayList<>(set);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}