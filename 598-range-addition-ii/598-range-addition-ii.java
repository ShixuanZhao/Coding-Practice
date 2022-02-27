class Solution {
    //就是找所有操作矩形的重叠部分。因为矩形的起点一致，所以分别找最小的宽高就行了。
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for(int[] op: ops){
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }    
        return x * y;
    }
}