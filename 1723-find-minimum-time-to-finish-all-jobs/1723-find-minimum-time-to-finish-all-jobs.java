class Solution {
//     public int minimumTimeRequired(int[] jobs, int k) {
//          //method1: binary search
//         //dp:也不行，左大段右小段 右小段：最后一个工人给他分配最后一个工作，最后2个....
//         //left is the max val, right is the sum
//         int left = 0;
//         int right = 0;
//         for (int job : jobs) {
//             left = Math.max(left, job);
//             right += job;
//         }
//         //the search space is from max to sum
//         while (left < right - 1) {
//             int mid = left + (right - left) / 2;
//             if (possible(jobs, new int[k], mid, 0)) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return possible(jobs, new int[k], left, 0) ? left : right; 
//     }
    
//     //dfs TLE
//     private boolean possible(int[] jobs, int[] group, int limit, int jobIndex) {
//         if (jobIndex == jobs.length) {
//             return true;
//         }
//         //j is the group index
//         for (int j = 0; j < group.length; j++) {
//             if (group[j] + jobs[jobIndex] > limit) {
//                 continue;
//             }
//             group[j] += jobs[jobIndex];
//             if (possible(jobs, group, limit, jobIndex + 1)) {
//                 return true;
//             }
//             group[j] -= jobs[jobIndex];
//         }
//         return false;
//     }
    
//     private void dfs(int[] jobs, int k, int[] sum, int[] res, int index) {
//         if (index == jobs.length) {
//             int max = 0;
//             for (int s : sum) {
//                 max = Math.max(s, max);
//             }
//             res[0] = Math.min(res[0], max);
//             return;
//         }
//         //把当前的工作分配给哪一个worker？
//         for (int i = 0; i < sum.length; i++) {
//             //subset2
//             if (i > 0 && sum[i] == sum[i - 1]) {
//                 continue;
//             }
//             sum[i] += jobs[index];
//             dfs(jobs, k, sum, res, index + 1);
//             sum[i] -= jobs[index];
//         }
//     }
        
        //prum
        //dfs + trum
        //level == jobs.length, 每层有k个选择，代表把当前的工作给哪一个worker，用int[] sum，记录每一个worker的工作和
        //工作从时间最长的开始分配
    public int minimumTimeRequired(int[] jobs, int k) { 
        Arrays.sort(jobs);
        int[] sum = new int[k];
        int[] res = new int[] {Integer.MAX_VALUE};
        dfs(jobs, jobs.length - 1, sum, res);
        return res[0];
    }
    
    private void dfs(int[] jobs, int index, int[] sum, int[] res) {
        if (index < 0) {
            //calculate the max in sum
            int max = 0;
            for (int s : sum) {
                max = Math.max(max, s);
            }
            res[0] = Math.min(res[0], max);
            return;
        }
        if (Arrays.stream(sum).max().getAsInt() >= res[0]) {
            return;
        }
        //一个工作分配给几个相同cycle的worker效果一样，我们只分配一个。比如：开始是000，工作量为8 800，080，008 其实是一样的
        for (int i = 0; i < sum.length; i++) {
            if (i > 0 && sum[i] == sum[i - 1]) {
                continue;
            }
            sum[i] += jobs[index];
            dfs(jobs, index - 1, sum, res);
            sum[i] -= jobs[index];
        }
    }
    
}