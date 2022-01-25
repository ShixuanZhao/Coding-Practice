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
        
        int n = heights.length;
        //store the index that can have an ocean view
        List<Integer> temp = new ArrayList<>();
        //maintain prev max
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) {
                temp.add(i);
                max = heights[i];
            }
        }
        //increasing order
        int index = 0;
        int[] res = new int[temp.size()];
        for (int i = temp.size() - 1; i >= 0; i--) {
            res[index++] = temp.get(i);
        }
        return res;
    }
}