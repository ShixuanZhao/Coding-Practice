class Solution {
    /*
    我们有一个背包，背包的容量为m个1和n个0。我们有一堆物品可以拿，每个物品空间为一些0和一些1.我们可以选择讲每个物品放入包中或者不放。求最后我们能最多放入多少个物品。
    */
    public int findMaxForm(String[] strs, int m, int n) {
        //M[i][j]:the max size of subset of whole strs using at most m 0 and n 1
        int[][] M = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0;
            int one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            //M[i][j] = Math.max(M[i][j], M[i - zero][j - one] + 1)
            ////只要目前剩余的空间比这个物品的空间大 我们可以选择拿，牺牲空间得到count + 1
            //注意遍历顺序，因为利用滚动数组牺牲了str轮数这个维度，左边相当于M[l][][],右边相当于M[l - 1][i][j]
            //所以当前轮不应该依赖于当前轮的结果，而是依赖于上一轮的结果，所以空间容量从大到小遍历，不存在当前轮的依赖关系
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    M[i][j] = Math.max(M[i][j], M[i - zero][j - one] + 1);
                }
            }
        }
        return M[m][n];
    }
}