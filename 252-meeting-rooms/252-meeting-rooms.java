class Solution {
    /*
        ------prev
             min end
                 ------cur
                 max start
        case1:prev.end >= cur.start there is overlapping, return falsle
        case2:prev.end < cur.start, continue to compare another two pairs
    */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i - 1];
            int[] cur = intervals[i];
            if (prev[1] > cur[0]) {
                return false;
            } 
        }
        return true;
    }
}