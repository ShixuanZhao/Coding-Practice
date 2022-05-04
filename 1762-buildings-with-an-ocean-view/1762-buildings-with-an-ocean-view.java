class Solution {
    /*
    max: the max value to its right
    if cur height > max height, it have ocean view
    so we iterate the array backward, compare cur and max, and update the max
     0 1 2 3
    [4,2,3,1]
    list:3 2 0
    */
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(n - 1);
        int max = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > max) {
                temp.add(i);
                max = heights[i];
            }
        }
        int[] res = new int[temp.size()];
        int index = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            res[index++] = temp.get(i);
        }
        return res;
    }
}