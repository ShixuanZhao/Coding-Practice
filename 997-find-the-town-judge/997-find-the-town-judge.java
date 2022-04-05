class Solution {
//     Consider trust as a graph, all pairs are directed edge.
// The point with in-degree - out-degree = N - 1 become the judge.
    public int findJudge(int N, int[][] trust) {
        //becasue we label 1 to n
        int[] Trusted = new int[N+1];
        for(int[] person : trust){
            Trusted[person[0]]--;
            Trusted[person[1]]++;
        }
        for(int i = 1;i < Trusted.length;i++){
            if(Trusted[i] == N-1) return i;
        }
        return -1;
    }
}