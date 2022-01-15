/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
/*
Free time is a period of time such that no employees scheduled to work, i.e. the gap between every two non-overlapping intervals. If we meet a start of interval, score++; or else(if we meet an end of interval), score--. Non-overlapping intervals exist when score equals to 0.
We add current gap interval to the result list when score is not 0 any more.
1 2 3    4 5 6  10
2 -1 -1  1 1 -1 -1
     0   1                cnt
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Map<Integer, Integer> map = new TreeMap<>(); // Key: time point, value: score.
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
                map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
            }
        }
        List<Interval> res = new ArrayList<>();
        int start = -1;
        int cnt = 0;
        for (int point : map.keySet()) {
            cnt += map.get(point);
            if (start == -1 && cnt == 0) {
                start = point;
            } else if (start != -1 && cnt != 0) {
                res.add(new Interval(start, point));
                start = -1;
            }
        }
        return res;
    }
}