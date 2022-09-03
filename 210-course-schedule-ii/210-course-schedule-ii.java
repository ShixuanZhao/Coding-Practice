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
}