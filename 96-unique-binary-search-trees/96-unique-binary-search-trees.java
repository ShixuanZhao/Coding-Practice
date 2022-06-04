class Solution {
    /*
        //divide and conquer  recursion -> TLE
        step1:choose either node number as root noot
        (1 2) 3 (4 5)    n =5                      
          3        3   2(left subtree) * 2(right subtree)
        1        2    
          2    1
          (1) 2 (3 4 5)   left * right
          left    right
          base case: if there is only one node or no node in the subtree, return 1
          
          //M2:dp
          M[i]:the number of BST which size is n
          M[1] = 1; M[2] = 2
          1 2 3 M[3] = M[2] + M[1] * M[1] + M[2] = 5
          M[i] += M[j - 1] * M[i - j]  1 <= j <= i j represent the root we can choose
    */
    // public int numTrees(int n) {
    //     if (n == 1 || n == 0) {
    //         return 1;
    //     }
    //     int sum = 0;
    //     //try to choose each element as the root
    //     for (int i = 1; i <= n; i++) {
    //         int leftRes= numTrees(i - 1);
    //         int rightRes = numTrees(n - i);
    //         sum += leftRes * rightRes;
    //     }
    //     return sum;
    // }
    
    public int numTrees(int n) {
        //the number of unique of BST using the first i ele
        int[] M = new int[n + 1];
        //M[0] = 1 not 0
        M[0] = 1;
        M[1] = 1;
        for (int i = 2; i <= n; i++) {
            //the number of node including root
            for (int j = 1; j <= i; j++) {
                M[i] += M[j - 1] * M[i - j];
            }
        }
        return M[n];
    }
}