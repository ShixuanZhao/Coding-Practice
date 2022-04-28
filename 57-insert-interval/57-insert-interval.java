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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        //begin to merge
        //the judge condition is important
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}