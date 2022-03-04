class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        //put small ele into left, put large ele into right
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        //-------i
        //tail   head
        //i is the head of the window
        for(int i = 0; i < nums.length; i++) {
            if(left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }


            if(left.size() + right.size() == k) {
                double median;
                if(left.size() == right.size()) {
                    median = (double) ((long)left.peek() + (long)right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                //remove the tail from either left or right depend on which heap has this ele
                //Java PQ remove() takes O(n)
                if(!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return result;
    }
        
}