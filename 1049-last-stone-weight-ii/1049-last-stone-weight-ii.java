class Solution {
    /*
    Same problem as:
Divide all numbers into two groups,
what is the minimum difference between the sum of two groups.
Now it's a easy classic knapsack problem.
s1 + s2 = sum
s1 - s2 = diff
2 * s1 = sum + diff
diff = sum - 2 * s1 -> s2 close to sum / 2

Brief Prove
All cases of "cancellation of rocks" can be expressed by two knapsacks.
And the last stone value equals to the difference of these two knapsacks
It needs to be noticed that the opposite proposition is wrong.

    */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        //the max cloestest value to target
        int[][] M = new int[stones.length + 1][target + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - stones[i - 1] < 0) {
                    M[i][j] = M[i - 1][j];
                } else {
                    M[i][j] = Math.max(M[i - 1][j], M[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * M[stones.length][target];
    }
}