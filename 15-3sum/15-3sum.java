class Solution {
    /*
        input:int[]  
        output:List<List<Integer>>
        clarify: duplicate [1 1 2 -3] (1 2 -3) return one result
        nums == null || length == 0
        return empty list
        high level:
        step1:sort the nums in increasing order
        step2:ancher i
            and do two sum between i + 1 to length - 1
        for i 
            while (l < r) {
                two sum which T = -nums[i]
            }
        two sum: use two pointers
        case1:sum < T, move l to right
        case2:sum > T, move r to left
        case3:sum == T, add 3 tuple into res, and move l and r
        sum = l + r
        sum <
        round1:two sum == 4  
         round2:two sum == 1 
         
        [-4, -1, -1, 0, 1, 2]
                       i  
                        l
                            r
                        T = O(nlogn + n^2) = O(n^2)
                        S = O(1)
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        //corner case
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //step1
        Arrays.sort(nums);
        //step2
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            //skip duplicate num
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //do 2 sum
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                    //can also skip the duplicate one
                } else if (sum > target) {
                    right--;
                     //can also skip the duplicate one
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    //[0 0 0] T = 0 res: [0, 0] skip the duplicate one
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}