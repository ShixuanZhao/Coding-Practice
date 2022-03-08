class Solution {
    /*
    状态机
      因此可以设定为 f[][]f[][] 作为动规数组：

第一维为可变参数 uu，代表石子列表的下标，范围为数组 stones 长度；
第二维为可变参数 kk，代表上一步的的跳跃步长，前面也分析过了，最多不超过数组 stones 长度。
这样的「状态定义」所代表的含义：当前在第 ii 个位置，并且是以步长 kk 跳到位置 ii 时，是否到达最后一块石子。

那么对于 f[i][k]f[i][k] 是否为真，则取决于上一位置 jj 的状态值，结合每次步长的变化为 [-1,0,1] 可知：

可从 f[j][k - 1]f[j][k−1] 状态而来：先是经过 k - 1k−1 的跳跃到达位置 jj，再在原步长的基础上 +1，跳到了位置 ii。
可从 f[j][k]f[j][k] 状态而来：先是经过 kk 的跳跃到达位置 jj，维持原步长不变，跳到了位置 ii。
可从 f[j][k + 1]f[j][k+1] 状态而来：先是经过 k + 1k+1 的跳跃到达位置 jj，再在原步长的基础上 -1，跳到了位置 ii。
只要上述三种情况其中一种为真，则 f[i][j]f[i][j] 为真。
f[1][1] = true
    */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // check first step
        if (stones[1] != 1) return false;
        boolean[][] f = new boolean[n][n];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃

                // 而从位置 j 发起的跳跃最多不超过 j + 1
                // 因为每次跳跃，下标至少增加 1，而步长最多增加 1 
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
    }
}