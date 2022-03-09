class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //    //keep a pq which size == k
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));
    //     for (int i = 0; i < nums.length; i++) {
    //         if (minHeap.size() < k) {
    //             minHeap.offer(nums[i]);
    //         } else if (nums[i] > minHeap.peek()) {
    //             minHeap.poll();
    //             minHeap.offer(nums[i]);
    //         }
    //     }
    //     return minHeap.peek();
    // }
    
     public int findKthLargest(int[] nums, int k) {
        //quick select
        quickSelect(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
//averge T = O(n)每次排除一半 n + n/2 + n/4 ... = 2n - 1 = O(n)
    private void quickSelect(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return;  
        }
        int pos = partition(nums, left, right);
        if (pos == nums.length - k) {
            return;
         //      |  k   |
         // ------------         
         //      a   pos   a = nums.length - k
        } else if (pos > nums.length - k) {
            quickSelect(nums, k, left, pos - 1);
        } else {
            quickSelect(nums, k, pos + 1, right);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        //choose the rightmost element as the pivot
        int val = nums[right];
        int i = left;
        int j = right - 1;
        //[i, j] are the area that need to be explored
        while (i <= j) {
            if (nums[i] < val) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//  public int findKthLargest(int[] nums, int k) {
//         //quick select
//         quickSelect(nums, k, 0, nums.length - 1);
//         return nums[nums.length - k];
//     }
    
// averge T = O(n)每次排除一半 n + n/2 + n/4 ... = 2n - 1 = O(n)
//     private void quickSelect(int[] nums, int k, int left, int right) {
//         if (left >= right) {
//             return;  
//         }
//         int pos = partition(nums, left, right);
//         if (pos == nums.length - k) {
//             return;
//               |  k   |
//          ------------         
//               a   pos   a = nums.length - k
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