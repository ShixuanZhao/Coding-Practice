class Solution {
//     Just think about three cases:
// all positive - product of last three
// one negative - product of last three
    
    //M1
// two or more negative - either product of first two and last or product of last three
    // public int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    // }
    
    //follow up: extend to k number
    //sorting
    // all positive - product of last three
// one negative - product of last three
// two or more negative - either product of first two * last(k - 2) or product of last k
    
    //M2:find out the three largest numbers and the two smallest numbers using one pass.
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3){
                max3 = n;
            }
            
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
    
    //a solution that can extend to k numbers
//     public int maximumProduct(int[] nums) {
//         //minHeap
//         PriorityQueue<Integer> posHeap = new PriorityQueue<>(3);
//         //maxHeap
//         PriorityQueue<Integer> negHeap = new PriorityQueue<>(2, Collections.reverseOrder());
//         for (int x: nums) {
//             if (posHeap.size() < 3) {
//                 posHeap.offer(x);
//             } else if (posHeap.peek() < x) {
//                 posHeap.poll();
//                 posHeap.offer(x);
//             }
            
//             if (negHeap.size() < 2) {
//                 negHeap.offer(x);
//             } else if (negHeap.peek() > x) {
//                 negHeap.poll();
//                 negHeap.offer(x);
//             }
//         }
//         int c1 = 1;
//         int max = 0;
//         while (!posHeap.isEmpty()) {
//             max = posHeap.poll();
//             c1 *= max;
//         }
//         while (!negHeap.isEmpty()) {
//             max *= negHeap.poll();
//         }
//         return Math.max(c1, max);
//     }
}