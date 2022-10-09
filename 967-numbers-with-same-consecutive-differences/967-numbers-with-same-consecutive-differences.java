class Solution {
    /*
    Iterative BFS Solution
We initial the current result with all 1-digit numbers,
like cur = [1, 2, 3, 4, 5, 6, 7, 8, 9].

Each turn, for each x in cur,
we get its last digit y = x % 10.
If y + K < 10, we add x * 10 + y + K to the new list.
If y - K >= 0, we add x * 10 + y - K to the new list.

We repeat this step N - 1 times and return the final result.
    */
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> cur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //i is the len of each ele in arr
        for (int i = 2; i <= n; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            //BFS each time append one letter for each ele in cur
            for (int x : cur) {
                int y = x % 10;
                //can choose add or substract
                if (y + k < 10)
                    cur2.add(x * 10 + y + k);
                if (k > 0 && y - k >= 0)
                    cur2.add(x * 10 + y - k);
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(j->j).toArray();
    }
}