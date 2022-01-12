class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    //因为是无向图所以要记录一下前一个recursion访问的node
    //因为建图的时候是，u里面有v，v里面有u，记录一下dfs的方向因为dfs会触底反弹
    //如果是有向图判断有没有坏就不用记录prev node
    //模板，dfs with parent
    //记录每个node是从哪来的，如果他的爸爸和他的邻居是一个说明走了回头路，我们不管
    //但是如果二者不相同就说明有环
    //   1
    //  2 0
    //从1开始，2是从1来的他的邻居是0，这样就是有环
     boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
         //nei
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            if (!visited[v]) {
                if (hasCycle(adjList, v, visited, u)) {
                    return true;
                }
            } else {
                if (parent != v) {
                    return true;
                }
            }
        }
         return false;
    }
}