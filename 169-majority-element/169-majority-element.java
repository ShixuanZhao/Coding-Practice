class Solution {
//     public int majorityElement(int[] nums) {
//         //method1:sorting and take the mid value
//         //O(nlogn)
//         // Arrays.sort(nums);
//         // int mid = nums.length / 2;
//         // return nums[mid];
        
//         /*
//             //voting
//             nums =     [3,2,3]
//              candidate  3 2 3 
//                    cnt  1 1 0
//             candidate:possible majority element
//             cnt:the number
//         */
//         //method2:best solution, voting
//         //if we exclude two different number, the res would not change
//         //排除法，假设第一个是众数。同样的思路名流问题
//         // int cnt = 1;
//         // int candidate = nums[0];
//         // for (int i = 1; i < nums.length; i++) {
//         //     if (nums[i] == candidate) {
//         //         cnt++;
//         //     } else {
//         //         cnt--;
//         //         if (cnt == 0) {
//         //             candidate = nums[i];
//         //             cnt = 1;
//         //         }
//         //     }
//         // }
//         // return candidate;
        
//         //divide and conquer like merge sort
//         //T = O(nlogn) S = O(logn)
//         return findMaj(nums, 0, nums.length - 1);
//     }
    
//     private int findMaj(int[] nums, int left, int right) {
//         //base case
//         if (left == right) {
//             return nums[left];
//         }
//         int mid = left + (right - left) / 2;
//         int leftRes = findMaj(nums, left, mid);
//         int rightRes = findMaj(nums, mid + 1, right);
//         if (leftRes == rightRes) {
//             return leftRes;
//         }
//         int leftCnt = count(nums, left, right, leftRes);
//         int rightCnt = count(nums, left, right, rightRes);
//         return leftCnt > rightCnt ? leftRes : rightRes;
//     }
    
//     private int count(int[] nums, int left, int right, int target) {
//         int cnt = 0;
//         for (int i = left; i <= right; i++) {
//             if (nums[i] == target) {
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
    
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    candidate = nums[i];
                    cnt = 1;
                }
            }
        }
        return candidate;
    }
}