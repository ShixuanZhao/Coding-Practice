class Solution {
    /*
    two pass:
    XXXX|XXXX
       i i + 1
       A[i]:隔板前面需要移除的b的个数 forward traverse including i
       B[i]:隔板后面需要移除的a的个数 backward traverse  including i
       res = Min(A[i] + B[i])
       "ababbab"
        0112334
    */
    public int minimumDeletions(String s) {
        int n = s.length();  
        int[] A = new int[n];
        A[0] = s.charAt(0) == 'b' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            A[i] = A[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
            //System.out.print(A[i]);
        }
        
        int[] B = new int[n];
        B[n - 1] = s.charAt(n - 1) == 'a' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            B[i] = B[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        
        //corner case:|bbbb or aaaa|
        int res = Math.min(A[n - 1], B[0]);
        //iterate '|'
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, A[i] + B[i + 1]);
        }
        return res;
    }
}