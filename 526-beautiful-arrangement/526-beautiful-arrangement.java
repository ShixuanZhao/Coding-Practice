class Solution {
    //M1
//     int res = 0;
//     public int countArrangement(int n) {
//         //1-base
//         boolean[] used = new boolean[n + 1];
//         helper(n, 1, used);
//         return res;
//     }
    
//     private void helper(int n, int index, boolean[] used) {
//         if (index == n + 1) {
//             res++;
//             return;
//         }
//         for (int i = 1; i <= n; i++) {
//             if (!used[i] && (i % index == 0 || index % i == 0)) {
//                 used[i] = true;
//                 helper(n, index + 1, used);
//                 used[i] = false;
//             }
//         }
//     }
    int count = 0;
    private void helper(int[] nums, int start) {
        if (start == nums.length) {
            count++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) helper(nums, start+1);
            swap(nums,i, start);
        }
    }
    public int countArrangement(int N) {
        if (N == 0) return 0;
        int[] nums = new int[N+1];
        for (int i = 0; i <= N; i++) nums[i] = i;
        helper(nums, 1);
        return count;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}