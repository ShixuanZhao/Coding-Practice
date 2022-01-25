class Solution {
    public int[] findBuildings(int[] heights) {
        // int n = heights.length;
        // int[] M = new int[n + 1];
        // M[n] = Integer.MIN_VALUE;
        // M[n - 1] = heights[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     M[i] = Math.max(M[i + 1], heights[i]);
        // }
        // List<Integer> res = new LinkedList<>();
        // for (int i = 0; i < n; i++) {
        //     if (heights[i] > M[i + 1]) {
        //         res.add(i);
        //     }
        // }
        // int[] temp = new int[res.size()];
        // for (int i = 0; i < temp.length; i++) {
        //     temp[i] = res.get(i);
        // }
        // return temp;
        List<Integer> ls = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > last) {
                ls.add(i);
                last = heights[i];
            }
        }
        
        int index = 0;
        int[] res = new int[ls.size()];
        for (int i = ls.size() - 1; i >= 0; i--)
            res[index++] = ls.get(i);
        
        return res;
    }
}