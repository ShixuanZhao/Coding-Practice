class Solution {
    /*
        Idea :
Given 2 nums 'a' and 'b':
If a % k == x and b % k == k - x :
then (a + b) is divisible by k

Keep count of remainders of all elements of arr
frequency[0] keeps all elements divisible by k, and a divisible of k can only form a group with other divisible of k. Hence, total number of such divisibles must be even.
for every element with remainder of i (i != 0) there should be a element with remainder k-i.
Hence, frequency[i] should be equal to frequency[k-i]
    */
    public boolean canArrange(int[] arr, int k) {
        //int[] index is 余数，val is count
        int[] freq = new int[k];
        //get the freq of each disiable
        for (int num : arr) {
            num %= k;
            if (num < 0) {
                num += k;
            }
            freq[num]++;
        }
        if (freq[0] % 2 != 0) {
            return false;
        }
        //i pair to k - i
        //i <= k / 2
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
}