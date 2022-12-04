class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // List<List<Integer>> adList = new LinkedList<>();
        // int len = numCourses;
        // for (int i = 0; i < len; i++) {
        //     adList.add(new LinkedList<Integer>());
        // }
        // int[] indegree = new int[len];
        // for (int[] p : prerequisites) {
        //     int start = p[1];
        //     int end = p[0];
        //     adList.get(start).add(end);
        //     indegree[end]++;
        // }
        // Queue<Integer> queue = new LinkedList<>();
        // for (int i = 0; i < len; i++) {
        //     if (indegree[i] == 0) {
        //         queue.offer(i);
        //     }
        // }
        // int[] res = new int[len];
        // int index = 0;
        // while (!queue.isEmpty()) {
        //     int cur = queue.poll();
        //     res[index++] = cur;
        //     for (int nei : adList.get(cur)) {
        //         if (--indegree[nei] == 0) {
        //             queue.offer(nei);
        //         }
        //     }
        // }
        // return index == numCourses ? res : new int[] {};
        
    
        //construct graph using map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int start = p[1];
            int end = p[0];
            graph.putIfAbsent(start, new LinkedList<>());
            graph.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            List<Integer> childList = graph.get(cur);
            //!!!!
            if (childList == null) {
                continue;
            }
            for (int child : childList) {
                if (--indegree[child] == 0) {
                    q.offer(child);
                }
            }
        }
        return index == numCourses ? res : new int[] {};
    }
    
    /*
    Follow up:给你一系列任务的完成时间及其前置依赖，任务可以并行，求完成所有任务的最短时间 
    拓扑排序加dp，其中dp[i]代表完成第i个任务需要的时间
dp[i]=(dp[j])+time[i]dp[i]=(j,i)∈Emax​(dp[j])+time[i]

     private int getAns(int[] times,List<List<Integer>> graph,int n){
        int[] in=new int[n];
        for(List<Integer> list:graph){
            for(int i:list)in[i]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        int[] dp=new int[n];
        Arrays.fill(dp,0);
        int cnt=0;
        for (int i = 0; i < n; i++) {
            if (in[i]==0){
                dp[i]=times[i];
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int curr=queue.poll();
            cnt++;
            for(int i:graph.get(curr)){
                in[i]--;
                dp[i]=Math.max(dp[i],dp[curr]+times[i]);
                if (in[i]==0)queue.add(i);
            }
        }
        if (cnt!=n)return -1;
        int ans=0;
        for (int i = 0; i <dp.length ; i++) {
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    */
}