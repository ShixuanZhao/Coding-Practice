class Solution {
    public int[] frequencySort(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //key is in the pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b - a;
            }
            return map.get(a) - map.get(b);
        });
        for(int key : map.keySet()){
            pq.offer(key);
        }
        int[] res = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int key = pq.poll();
            int val = map.get(key);
            for (int i = 0; i < val; i++) {
                res[index++] = key;
            }
        }
        return res;
    }
}