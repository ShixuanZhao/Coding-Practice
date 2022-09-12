class Solution {
    /*
        -----e cur
           s-----   new interval
         new.start <= cur.end && cur.start < new.end merge repeatedly: end = max(prev.end, cur.end) start = min(prev.start, new.start)
         else:  add to res
         -----e cur
 s-----   new interval
 
 [1,2],[3,5],[6,7],[8,10],[12,16]   [4,8]
                             i
        
  [3,10]
  compare the newInterval.start and cur.end find the interval begin to merge
  keep mergeing min(start) max(end)
 ------- old
     ------- new
     
              ------- old  (wrong)
     ------- new
     we also need to ensure new.end >= old.start
    */
    // public int[][] insert(int[][] intervals, int[] newInterval) {
    //     int n = intervals.length;
    //     List<int[]> res = new ArrayList<>();
    //     //find the position that can begin to merge
    //     int i = 0;
    //     while (i < n && intervals[i][1] < newInterval[0]) {
    //         res.add(intervals[i]);
    //         i++;
    //     }
    //     //keep merging
    //     while (i < n && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
    //         newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    //         newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    //         i++;
    //     }
    //     res.add(newInterval);
    //     while (i < n) {
    //         res.add(intervals[i]);
    //         i++;
    //     }
    //     return res.toArray(new int[res.size()][2]);
    // }
    
    /*
    ------  -----    -------
           ----- new interval
    case1:non-overlap: cur.end < newInterval.start
    case2: non-overlap: cur.start > newInterval.end
    case3:overlap: the rest
    merge, extend new.start , new.end
    when add newInterval to res:
    1.reach the case2
    2.no case2, add at the end
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        boolean inserted = false;
        List<int[]> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[1] < newInterval[0]) {
                res.add(cur);
            } else if (cur[0] > newInterval[1]) {
                if (!inserted) {
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(cur);
            } else {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        if (!inserted) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}