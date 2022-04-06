class Solution {
    /*
    The first solution uses O(k*n^2) space for simplicity:
At every k and position i j we store the probability that the knight landed at position i j at step k. We know that this probability is the sum of probabilities of the 8 directions in the previous step k-1 because in the previous step all 8 of those knight's have a chance of moving here. For example since one of the directions is 2, 1 we take the current i-2 and j-1 and add that probability/8.0 (because if the knight is currently at i-2, j-1 the chance is only /8.0 that he'll choose this direction out of his 7 other choices).
We initialize the r , c index of the k==0 board to 1, because at step 0, we already have the knight at position r, c so the chance it lands there in 0 steps is 100%.
The result is the sum of probabilities in all areas of the board in the Kth index Board.
    */
    int [][] direction =new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
   
    public double knightProbability(int N, int K, int r, int c) {
        double [][][] ways = new double[K+1][N][N];
        ways[0][r][c]=1;
        for(int k=1; k<=K;++k){
            for(int i=0; i<N;++i){
                for(int j=0; j<N;++j){
                    for(int [] dir: direction){
                        int oldR = i-dir[0];
                        int oldC = j-dir[1];
                        if(oldR>=0 && oldC>=0 && oldR<N && oldC<N){
                            ways[k][i][j]+=(ways[k-1][oldR][oldC]/8.0);
                        }
                    }
                }
            }
        }
        double res = 0;
        for(int i=0; i<N;++i){
            for(int j=0; j<N;++j){
                res+=ways[K][i][j];
            }
        }
        return res;
    }
}