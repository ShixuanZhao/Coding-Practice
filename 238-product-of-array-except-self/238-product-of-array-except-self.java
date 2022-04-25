class Solution {
    /*
        high level: step1:for each element in nums, calculate prefixProd(exclusive) array and suffixProd array(three pass)
index        0 1 2 3
            [1,2,3,4]
prefixProd   1 1 2 6
suffixProd  24 12 4 1
                    step2:for each index i, prefixProd[i] * suffixProd[i]
        T = O(n) S = O(n)
        
        save space?
        use only one array and res array
        //follow up use O(1) space except for res array
        step1:calculate prefixProd array store the result to res array(scan from left to right)
        step2:use a variable right to represent suffixProd, calculate the suffixProd and update the res array(scan from right to lefy)
        input:[1,2,3,4]
        step1:[1,1,2,6] res    prefix:6   
        step2:[24,12,8,6]   suffix:24
    */
    public int[] productExceptSelf(int[] nums) {
        // int n = nums.length;
        // int[] prefixProd = new int[n];
        // int[] suffixProd = new int[n];
        // prefixProd[0] = 1;
        // for (int i = 1; i < n; i++) {
        //     prefixProd[i] = prefixProd[i - 1] * nums[i - 1];
        // }
        // suffixProd[n - 1] = 1;
        // for (int i = n - 2; i >= 0; i--) {
        //     suffixProd[i] = suffixProd[i + 1] * nums[i + 1];
        // }
        // int[] res = new int[n];
        // for (int i = 0; i < n; i++) {
        //     res[i] = prefixProd[i] * suffixProd[i];
        // }
        // return res;
        int n = nums.length;
        int[] res = new int[n];
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}