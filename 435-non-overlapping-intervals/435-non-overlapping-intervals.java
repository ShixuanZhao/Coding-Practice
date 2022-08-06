class Solution {
    // public int eraseOverlapIntervals(int[][] intervals) {
    //     int n = intervals.length;
    //     //我们已经会求最多有几个区间不会重叠了，那么剩下的不就是至少需要去除的区间吗？
    //     return n - intervalSchedule(intervals);
    // }
    // //算出这些区间中最多有几个互不相交的区间
    // //如你今天有好几个活动，每个活动都可以用区间 [start, end] 表示开始和结束的时间，请问你今天最多能参加几个活动呢
    // public int intervalSchedule(int[][] intvs) {
    //     if (intvs.length == 0) return 0;
    //     // 按 end 升序排序
    //     Arrays.sort(intvs, new Comparator<int[]>() {
    //         public int compare(int[] a, int[] b) {
    //             return a[1] - b[1];
    //         }
    //     });
    //     // 至少有一个区间不相交 [1,3] [2,4] we should return 1
    //     int count = 1;
    //     // 排序后，第一个区间就是 x
    //     int x_end = intvs[0][1];
    //     for (int[] interval : intvs) {
    //         int start = interval[0];
    //         //如果一个区间不想与 x 的 end 相交，它的 start 必须要大于（或等于）x 的 end：
    //         if (start >= x_end) {
    //             // 找到下一个选择的区间了
    //             count++;
    //             x_end = interval[1];
    //         }
    //     }
    //     return count;
    // }
    
    //greedy:if conflict always remove cur one, to leave more space for the later
    /*
        -----prev, end
           -------cur
           remove cur, so we do not update end
    */
    // public int eraseOverlapIntervals(int[][] intervals) {
    //     if (intervals == null || intervals.length == 0) {
    //         return 0;
    //     }
    //     Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
    //     int end = Integer.MIN_VALUE;
    //     int cnt = 0;
    //     for (int i = 0; i < intervals.length; i++) {
    //         if (end <= intervals[i][0]) {
    //             //non-overlapping
    //             end = intervals[i][1];
    //         } else {
    //             //remove the cur one
    //             cnt++;
    //         }
    //     }
    //     return cnt;
    // }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - numOfNotOverlapping(intervals);
    }
    
    private int numOfNotOverlapping(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return 1;
        }
        //sort by end point
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                cnt++;
                end = intervals[i][1];
            }
            //if intersect, we keep the prev one
        }
        return cnt;
    }
}