class Solution {
    /*
    for row
        [1 1 0]
         i
        [1 0 0]
    */
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            int index = 0;
            for (int j = m - 1; j >= 0; j--) {
                temp[index++] = image[i][j] == 1 ? 0 : 1;
            }
            res[i] = temp;
        }
        return res;
    }
}