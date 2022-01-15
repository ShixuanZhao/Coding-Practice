class Solution {
    /*
    [[0,2],[5,10],[13,23],[24,25]]
       i
    [[1,5],[8,12],[15,24],[25,26]]
       j
       ------
           --------  maxStart < minEnd
    for next round, move the smaller pne
                 ------- i++
           ---------
    */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (maxStart <= minEnd) {
                res.add(new int[] {maxStart, minEnd});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}