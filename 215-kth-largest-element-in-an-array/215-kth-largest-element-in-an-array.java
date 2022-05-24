class Solution {
    /*
    int index = partition(nums, left, right)
    k is the k-th smallest index
    if index == k return
    if index < k left = index + 1
    else right = index - 1
    */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        //target index
        int target = n - k;
        int left = 0;
        int right = n - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }
    
    /*
    3,2,1,4,6,5
          i       
        j
    */
    private int partition(int[] nums, int left, int right) {
        //pivot index and val
        int index = right;
        int val = nums[index];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] < val) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, index);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
//     public int findKthLargest(int[] nums, int k) {
//         //quick select
//         quickSelect(nums, k, 0, nums.length - 1);
//         return nums[nums.length - k];
//     }
    
// //averge T = O(n)每次排除一半 n + n/2 + n/4 ... = 2n - 1 = O(n)
//     private void quickSelect(int[] nums, int k, int left, int right) {
//         if (left >= right) {
//             return;  
//         }
//         int pos = partition(nums, left, right);
//         if (pos == nums.length - k) {
//             return;
//          //      |  k   |
//          // ------------         
//          //      a   pos   a = nums.length - k
//             //pos右边可以排除他们都是比较大的，已经放在结果集里了，在左边再继续找
//         } else if (pos > nums.length - k) {
//             quickSelect(nums, k, left, pos - 1);
//         } else {
//             quickSelect(nums, k, pos + 1, right);
//         }
//     }
    
//     private int partition(int[] nums, int left, int right) {
//         //choose the rightmost element as the pivot
//         int val = nums[right];
//         int i = left;
//         int j = right - 1;
//         //[i, j] are the area that need to be explored
//         while (i <= j) {
//             if (nums[i] < val) {
//                 i++;
//             } else {
//                 swap(nums, i, j);
//                 j--;
//             }
//         }
//         swap(nums, i, right);
//         return i;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }
}