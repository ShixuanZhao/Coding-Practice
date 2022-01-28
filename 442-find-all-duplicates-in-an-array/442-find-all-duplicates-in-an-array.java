class Solution {
    /*
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
     0 1 2
    [-1,-2,2]
    res:1
      
    */
    public List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList();
      for(int num : nums){
        int n = Math.abs(num);
        int index = n - 1;
        if(nums[index] < 0) res.add(n);
        nums[index] = -nums[index];
      }
      return res;
    }
}