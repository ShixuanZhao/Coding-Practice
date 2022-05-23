class Solution {
    /*
    bucket sort, 空间换时间，不用排序，时间从nlogn降低为n
    [1,1,4,2,1,3]  1 <= heights[i] <= 100
    1 2 3.. 100
    3 1 1
    
    */
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] bucket = new int[101];
        for (int h : heights) {
            bucket[h]++;
        }
        //compare bucket and heights
        //index in heights
        int index = 0;
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            if (bucket[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < bucket[i]; j++) {
                    if (heights[index] != i) {
                        res++;
                    }
                    index++;
                }
            }
        }
        return res;
    }
}