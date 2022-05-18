class Solution {
    /*
    adjancency matrix
    isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    110
    110
    001
    第一行：1和1连着，1和2连着，1和3不连
    第二行：2和1连着，2和2连着，2和3不连
    */
    public int findCircleNum(int[][] isConnected) {
        //number of city
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(isConnected, visited, i);
            }
        }
        return res;
    }
    
    //mark all connected city as visited
    //i is the start city
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        //all other city
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }
}