class Solution {
    /*
        high level: for given position,we need to find leftMax and rightMax
        so, the each point, the area would be (Math.min(leftMax, rightMax) - height[i]) * 1
        add each area
        [0,1,0,2(leftMax),1, 0(from) ,1,3(rightMax),2,1,2,1]
        topHeight = 2
        dp 
        leftMax: scan from left to right
        M[i]:the max value from index 0 to index i
        rightMax: scan from right to left
        M[j]: the max value from index j to index n - 1
        T = O(n)
        S = O(n)
        还不理解单调栈的做法
    */
    // public int trap(int[] height) {
    //     int n = height.length;
    //     //build dp[] to get max
    //     int[] leftMax = new int[n];
    //     leftMax[0] = height[0];
    //     for (int i = 1 ; i < n; i++) {
    //         leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    //     }
    //     int[] rightMax = new int[n];
    //     rightMax[n - 1] = height[n - 1];
    //     for (int i = n - 2; i >= 0; i--) {
    //         rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    //     }
    //     //begin to calculate the area
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         res += Math.min(leftMax[i], rightMax[i]) - height[i];
    //     }
    //     return res;
    // }
    
    //保持递减栈
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peekFirst()] < height[i]) {
                //湖底高度
                int pre = stack.pollFirst();
                //没有左墙壁了没法储水
                if (stack.isEmpty()) {
                    break;
                }
                //左右墙壁的最小值减去湖底
                int depth = Math.min(height[stack.peekFirst()], height[i]) - height[pre];
                int width = i - stack.peekFirst() - 1;
                res += depth * width;
            }
            stack.offerFirst(i);
        }
        return res;
    }
}