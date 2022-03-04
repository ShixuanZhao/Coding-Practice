class Solution {
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
    //     pq.offer(new int[] {0, 0, nums1[0] + nums2[0]});
    //     List<List<Integer>> res = new ArrayList<>();
    //     //must have a set to avoid generating duplicate state
    //     Set<int[]> visited = new HashSet<>();
    //     visited.add(new int[] {0, 0});
    //     while (!pq.isEmpty()) {
    //         int[] cur = pq.poll();
    //         res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
    //         if (--k == 0) {
    //             return res;
    //         }
    //         if (cur[0] + 1 < nums1.length && visited.add(new int[] {cur[0] + 1, cur[1]})) {
    //             pq.offer(new int[] {cur[0] + 1, cur[1], nums1[cur[0] + 1] + nums2[cur[1]]});
    //         }
    //         if (cur[1] + 1 < nums2.length && visited.add(new int[] {cur[0], cur[1] + 1})) {
    //             pq.offer(new int[] {cur[0], cur[1] + 1, nums1[cur[0]] + nums2[cur[1] + 1]});
    //         }
    //     }
    //     return res;
    // }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int[][] dirs = {{1, 0}, {0, 1}};
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (--k == 0) {
                return res;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < m && y < n && visited.add(x * n + y)) {
                    pq.offer(new int[] {x, y});
                }
            }
        }
        return res;
    }
    
}