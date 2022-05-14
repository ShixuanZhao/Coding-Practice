class Solution {
/*
two pointers [j, i]
Definition:
valid: describes a subarray that has its maximum in range L..R;
j: start index of the longest valid subarray up till i;
count: length of subarray A[j..x] where A[x] is the last number (within A[j..i]) that is still in range L..R;

Great idea, the explanation is: in every iteration, we add the number of valid subarrays that ends at the current element.
For example, for input A = [0, 1, 2, -1], L = 2, R = 3:
for 0, no valid subarray ends at 0;
for 1, no valid subarray ends at 1;
for 2, three valid subarrays end at 2, which are [0, 1, 2], [1, 2], [2];
for -1, the number of valid subarrays is the same as 2, which are [0, 1, 2, -1], [1, 2, -1], [2, -1];


nums = [2,1,4,3], left = 2, right = 3
              i
              j
        res:3
        cnt:1
*/
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                res += i - j + 1;
                cnt = i - j + 1;
            } else if (nums[i] < left) {
                res += cnt;
            } else {
                //nums[i] > right, so we should not include this ele in our sliding window
                cnt = 0;
                j = i + 1;
            }
        }
        return res;
    }
}