class Solution {
    // public int minMeetingRooms(int[][] intervals) {
    //     //起点+1，终点-1放进TreeMap
    //     //TreeMap根据key的大小从小到大排序,即时间的顺序
    //     Map<Integer, Integer> map = new TreeMap<>();
    //     for (int[] interval : intervals) {
    //         map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
    //         map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
    //     }
    //     int room = 0;
    //     int maxRoom = 0;
    //     //按照时间顺序，过一遍value
    //     for (int val : map.values()) {
    //         room += val;
    //         maxRoom = Math.max(maxRoom, room);
    //     }
    //     return maxRoom;
    // }
    
    //pq T = O(nlogn)
    /*
    pq store the meeting that have not end
    1.sort the interval by starting time
    2.iterate the arrat
    [[0,30],[5,10],[15,20]]
                     i
      pq:[0,30], [15,20]
    */
     public int minMeetingRooms(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
         pq.offer(intervals[0]);
         for (int i = 1; i < intervals.length; i++) {
             if (intervals[i][0] >= pq.peek()[1]) {
                 pq.poll();
             }
             pq.offer(intervals[i]);
         }
         return pq.size();
     }
}