class Solution {
    public int singleNumber(int[] nums) {
        //二进制表示，各个数位相加，如果出现3次，累加之后肯定能被3整除
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                //bit getter
                bit[i] += (num >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += bit[i] % 3 << i;
        }
        return res;
    }
}