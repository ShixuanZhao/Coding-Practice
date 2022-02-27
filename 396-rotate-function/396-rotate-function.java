class Solution {
    //数学方法
    //推导递推公式
    /*
    sum = a0 +...+ an-1
    fk = f(k - 1) - sum + n * nums[k - 1]
    */
    public int maxRotateFunction(int[] nums) {
        long sum = 0;
        long n = nums.length;
        long f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        long res = f;
        for (int k = 1; k < n; k++) {
            f = f - sum + n * nums[k - 1];
            res = Math.max(res, f);
        }
        return (int)res;
    }
}