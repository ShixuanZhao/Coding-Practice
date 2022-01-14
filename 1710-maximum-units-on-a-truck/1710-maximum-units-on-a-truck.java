class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //greedy 先取unit大的那种箱子，所以将box按容量的大小从大到小排序
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int res = 0;
        //2.先选择大的箱子，不够继续选次大的直到可装载数量用光
        for (int i = 0; i < boxTypes.length; i++) {
            int temp = Math.min(truckSize, boxTypes[i][0]);
            res += temp * boxTypes[i][1];
            truckSize -= temp;
            //装不下了
            if (truckSize == 0) {
                return res;
            }
        }
        //有可能全装得下
        return res;
    }
}