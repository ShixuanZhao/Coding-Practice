class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        //单向遍历task，现有的session能放进去就放，不能放就新开一个session
        //先安排load大的task
        Arrays.sort(tasks);
        int[] res = new int[] {Integer.MAX_VALUE};
        //session[i], 第i个session有多少workload
        //最多session不超过tasks.length
        int[] session = new int[tasks.length];
        dfs(tasks, sessionTime, res, tasks.length - 1, session, 0);
        return res[0];
    }
    
    //可以选择放进能放的session也可以选择新开一个session
    private void dfs(int[] tasks, int sessionTime, int[] res, int index, int[] session, int sessionCount) {
        if (sessionCount > res[0]) {
            return;
        }
        if (index < 0) {
            res[0] = Math.min(res[0], sessionCount);
            return;
        }
        //做选择，当前task加入哪个session
        for (int i = 0; i < sessionCount; i++) {
            if (session[i] + tasks[index] <= sessionTime) {
                //把当前task加入到旧session
                session[i] += tasks[index];
                dfs(tasks, sessionTime, res, index - 1, session, sessionCount);
                session[i] -= tasks[index];
            }
        }
        //目前有的session都满了装不下了
        //把当前task放入到一个新的session
        //sessionCount：session的个数已有的session从0到count - 1，新的index就是sessionCount
        session[sessionCount] += tasks[index];
        dfs(tasks, sessionTime, res, index - 1, session, sessionCount + 1);
        session[sessionCount] -= tasks[index];
    }
}