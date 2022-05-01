class Solution {
    /*
    [[1,2],[3,1],[2,4],[2,3],[4,4]] (3, 4)
                              i
      dis:1
      minDis:1 update when dis < minDis
      minIndex:2
    */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dis = -1;
        int minDis = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (dis < minDis) {
                    minDis = dis;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}