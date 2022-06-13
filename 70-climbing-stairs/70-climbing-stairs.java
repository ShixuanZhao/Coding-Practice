class Solution {
    //left big part is the subproblem, right small part we can choose 1 step ot 2 step
    // public int climbStairs(int n) {
    //     //M[i] i number of stair
    //     int[] M = new int[n + 1];
    //     M[0] = 1;
    //     M[1] = 1;
    //     for (int i = 2; i <= n; i++) {
    //         if (i - 1 >= 0) {
    //             M[i] = M[i - 1];
    //         }
    //         if (i - 2 >= 0) {
    //             M[i] += M[i - 2];
    //         }
    //     }
    //     return M[n];
    // }
    
    public int climbStairs(int n) {
        if (n <= 0) {
            return 1;
        }
        //just need to keep two variable
        //liear scan previous one step and previous two steps
        int one = 1;
        int two = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}