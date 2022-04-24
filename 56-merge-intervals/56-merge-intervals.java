class Solution {
    /*
        M1:step1:sort by start
        -------  prev
             -----  cur
        ---------- merge
                      -----
 step2   for each interval
            if  prev.end >= cur.start merge
            else cannot merge add prev to res
            T = O(nlogn + n) n is the length
    */
    public int[][] merge(int[][] intervals) {
       int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new LinkedList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                res.add(prev);
                prev = intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
    
    //TreeMap
        /*
            [1,4],[3,5]
            TreeMap  key:   1   3    4    5
            value(change):  +1  +1  -1  -1
                    cnt:0    1   2   1   0     (1,5)
                          
        */         
        // List<int[]> res = new LinkedList<>();
        // if (intervals == null || intervals.length == 0) {
        //     return new int[0][];
        // }
        // Map<Integer, Integer> map = new TreeMap<>();
        // for (int[] interval : intervals) {
        //     map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
        //     map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        // }
        // int cnt = 0;
        // int start = 0;
        // //当cnt开始为0，再一次变为0，这就是一个完整的interval
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (cnt == 0) {
        //         start = entry.getKey();
        //     }
        //     cnt += entry.getValue();
        //     if (cnt == 0) {
        //         res.add(new int[] {start, entry.getKey()});
        //     }
        // }
        // return res.toArray(new int[res.size()][2]);
        
        // int[][] cur = new int[res.size()][2];
        // for (int i = 0; i < res.size(); i++) {
        //     cur[i] = res.get(i);
        // }
        // return cur;
    
    //heap
//    public int[][] merge(int[][] intervals) {
//         List<int[]> list = new ArrayList<>();
//         Queue<Pair> pq = new PriorityQueue<>((x, y) -> x.a == y.a ? x.b - y.b : x.a - y.a);
//         for (int[] arr : intervals) {
//             pq.add(new Pair(arr[0], arr[1]));
//         }

//         if (pq.isEmpty()) return new int[][]{};

//         Pair curr = pq.poll();
//         while (!pq.isEmpty()) {
//             Pair next = pq.poll();
//             if (curr.b >= next.a) {
//                 curr.a = Math.min(curr.a, next.a);
//                 curr.b = Math.max(curr.b, next.b);
//             } else {
//                 list.add(new int[]{curr.a, curr.b});
//                 curr = next;
//             }
//         }
//         list.add(new int[]{curr.a, curr.b});
//         int[][] res = new int[list.size()][2];
//         int i = 0;
//         for (int[] arr : list) {
//             res[i] = arr;
//             i++;
//         }
//         return res;
//     }
// }

// class Pair {
//     int a;
//     int b;

//     Pair(int x, int y) {
//         a = x;
//         b = y;
//     }
}