class Solution {
    /*
    矩阵变换成线性，线性怎么反变换成矩阵
    M[i]->M[i/col][i%col]
    */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        //i is the index in linear form, the liner index would be the same if both of the matrix are be converted to linear
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }
}