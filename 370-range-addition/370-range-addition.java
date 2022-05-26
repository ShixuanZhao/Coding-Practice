class Solution {
    /*
    for each update[]
    mark start with +val and end + 1 with -val
    0 1 2 3  4
      2 3    -2
    0 2 5  5 3  
    sum:2 3
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        //lazy computation,在开始和结束的后一个位置加上num，再run rolling sum， T = O(update.length + length)
        //Update only the first and end element is sufficient.
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            //到最后了，说明全部都包括了，所以我们就不需要再开一个减法区域了，因为后面没有数字了
            if (end < length - 1) {
                res[end + 1] -= value;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
       return res; 
    }
}