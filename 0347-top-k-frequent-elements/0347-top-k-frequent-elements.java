class Solution {
    /*
        clarify:n k
        k >= n return all element
        else top k
        return the element according to the freq from large to small
        [1 1 1 2 2 2 3] k == 1
        return any number
        input:int[] nums(nor null), int k
        output:int[]
        ds:map, minHeap size == k
        
        step1:freqMap <num, freq>
        step2:iterate each entry in the map
        case1:size of minHeap < k, push into map
        case2: >=K 
            top of minHeap < next ele:pop the top, push the new element into heap
            else do nothing
        step3:pop all the element in the heap, output the res 
    */
    public int[] topKFrequent(int[] nums, int k) {
        //corner case
        if (k >= nums.length) {
            return nums;
        }
        //step1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        //step2
        //define minHeap
        PriorityQueue<Map.Entry<Integer,  Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            //case1
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                //case2
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        //step3
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
}