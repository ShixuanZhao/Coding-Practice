class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int curSum = 0;
        int cnt = 0;
        for (int num : arr) {
            curSum += num;
            if (curSum == sum / 3) {
                curSum = 0;
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}