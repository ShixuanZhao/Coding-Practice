class Solution {
    /*
    use a treemap, key is the time point, val is the change
    0  5 10   15 20  30
    1  1  -1  1  -1   -1
cnt:                  0
res:2
    */
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] cur : intervals) {
            map.put(cur[0], map.getOrDefault(cur[0], 0) + 1);
            map.put(cur[1], map.getOrDefault(cur[1], 0) - 1);
        }
        int res = 0;
        int cnt = 0;
        for (int cur : map.values()) {
            cnt += cur;
            res = Math.max(res, cnt);
        }
        return res;
    }
    
    //pq T = O(nlogn)
    /*
    pq store the meeting that have not end
    1.sort the interval by starting time
    2.iterate the arrat
    [[0,30],[5,10],[15,20]]
                     i
      pq:[0,30], [15,20]
    */
     // public int minMeetingRooms(int[][] intervals) {
     //     Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
     //     //pq always pop the earliest ending time
     //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
     //     pq.offer(intervals[0]);
     //     for (int i = 1; i < intervals.length; i++) {
     //         if (intervals[i][0] >= pq.peek()[1]) {
     //             pq.poll();
     //         }
     //         pq.offer(intervals[i]);
     //     }
     //     return pq.size();
     // }
}