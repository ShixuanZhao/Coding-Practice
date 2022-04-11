class Solution {
    int res = Integer.MAX_VALUE;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int[] session = new int[tasks.length];
        dfs(tasks, sessionTime, 0, tasks.length - 1, session);
        return res;
    }
    
    private void dfs(int[] tasks, int sessionTime, int cnt, int index, int[] session) {
        if (cnt > res) {
            return;
        }
        if (index < 0) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = 0; i < cnt; i++) {
            if (session[i] + tasks[index] <= sessionTime) {
                session[i] += tasks[index];
                dfs(tasks, sessionTime, cnt, index - 1, session);
                session[i] -= tasks[index];
            }
        }
        session[cnt] += tasks[index];
        dfs(tasks, sessionTime, cnt + 1, index - 1, session);
        session[cnt] -= tasks[index];
    }
}