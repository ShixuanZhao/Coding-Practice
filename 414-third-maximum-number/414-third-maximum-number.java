class Solution {
    /*
    initialize max123 as Integer.MIN_VALUE is not right because we can have this corner case value
    so as null can handle with corner case or Long.MIN_VALUE
    */
    // public int thirdMax(int[] nums) {
    //     Integer max1 = null;
    //     Integer max2 = null;
    //     Integer max3 = null;
    //     for (Integer n : nums) {
    //         because we need distinct one
    //         if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
    //         if (max1 == null || n > max1) {
    //             max3 = max2;
    //             max2 = max1;
    //             max1 = n;
    //         } else if (max2 == null || n > max2) {
    //             max3 = max2;
    //             max2 = n;
    //         } else if (max3 == null || n > max3) {
    //             max3 = n;
    //         }
    //     }
    //     return max3 == null ? max1 : max3;
    // }
    
    //for scalable
    public int thirdMax(int[] nums) {
        //minHeap size == 3
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       Set<Integer> set = new HashSet<>();
       for(int n : nums) {
           //not consider the duplicate one
           if(set.add(n)) {
               pq.offer(n);
               if(pq.size() > 3 ) pq.poll();
           }
       }
        //this case we return max1
       if(pq.size() == 2) pq.poll();
       return pq.peek();
    }
}