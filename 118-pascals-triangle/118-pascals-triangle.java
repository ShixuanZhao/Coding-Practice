class Solution {
    /*
        //dp
        0 1 2 3 4
      0 1
      1 1 1
      2 1 2 1
      3 1 3 3 1
      4 1 4 6 4 1
      M[i][j] the value at position (i, j) i,j are index
      M[i][j] = M[i - 1][j] + M[i - 1][j - 1] j != 0 && i != j
      M[i][0] = 1
      M[i][i] = 1
    */
    // public List<List<Integer>> generate(int numRows) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     int[][] M = new int[numRows][numRows];
    //     M[0][0] = 1;
    //     List<Integer> cur = new ArrayList<>();
    //     cur.add(1);
    //     res.add(cur);
    //     for (int i = 1; i < numRows; i++) {
    //         List<Integer> temp = new ArrayList<>();
    //         M[i][0] = 1;
    //         temp.add(M[i][0]);
    //         for (int j = 1; j < i; j++) {
    //             M[i][j] = M[i - 1][j] + M[i - 1][j - 1];
    //             temp.add(M[i][j]);
    //         }
    //         M[i][i] = 1;
    //         temp.add(M[i][i]);
    //         res.add(temp);
    //     }
    //     return res;
    // }
    
    //calculate element value: K(i)(j)=K(i-1)(j-1)+K(i-1)(j) except for the first and last element
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //for each row
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}