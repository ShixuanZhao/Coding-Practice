class Solution {
    private boolean ok = true;
    private boolean[] color;
    private boolean[] visited;
    //         如果你把每个人看做图中的节点，相互讨厌的关系看做图中的边，那么dislikes数组就可以构成一幅图；

    // 又因为题目说互相讨厌的人不能放在同一组里，相当于图中的所有相邻节点都要放进两个不同的组；

    // 那就回到了「双色问题」，如果能够用两种颜色着色所有节点，且相邻节点颜色都不同，那么你按照颜色把这些节点分成两组不就行了嘛。

    // 所以解法就出来了，我们把dislikes构造成一幅图，然后执行二分图的判定算法即可：
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(n, dislikes, map);
        //因为可能有孤岛，多个disjoint graph
        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                dfs(map, v);
            }
        }
        return ok;
    }

    // 建图函数
    private void buildGraph(int n, int[][] dislikes, Map<Integer, List<Integer>> map) {
       for (int[] cur : dislikes) {
           // 「无向图」相当于「双向图」
           map.putIfAbsent(cur[0], new LinkedList<>());
           map.get(cur[0]).add(cur[1]);
           map.putIfAbsent(cur[1], new LinkedList<>());
           map.get(cur[1]).add(cur[0]);
       }
    }
    
    //dfs
    private void dfs(Map<Integer, List<Integer>> map, int v) {
        if (!ok) {
            return;
        }
        if (!map.containsKey(v)) {
            return;
        }
        visited[v] = true;
        for (int u : map.get(v)) {
            if (!visited[u]) {
                color[u] = !color[v];
                dfs(map, u);
            } else {
                if (color[u] == color[v]) {
                    ok = false;
                    return;
                }
            }
        }
    }
}