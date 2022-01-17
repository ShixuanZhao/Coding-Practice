class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        //for each city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(i, isConnected, visited);
            }
        }
        return res;
    }
    
    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        //mark nei
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(j, isConnected, visited);
            }
        }
    }
}