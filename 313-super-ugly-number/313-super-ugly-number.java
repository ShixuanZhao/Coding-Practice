class Solution {
    //ugly number2
    public int nthSuperUglyNumber(int n, int[] primes) {
        //tuple:
        //a[0]:value
        //a[1]:prime which linkedlist
        //a[2]:the index in each linkedlist, how far we gone through
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < primes.length; i++) {
            pq.add(new int[] {primes[i], primes[i], 0});
        }
        int[] M = new int[n];
        M[0] = 1;
        int i = 1;
        while (i < n) {
            int[] cur = pq.poll();
            int val = cur[0];
            int prime = cur[1];
            int index = cur[2];
            //if not duplicate
            if (val != M[i - 1]) {
                M[i] = val;
                i++;
            }
            pq.offer(new int[] {prime * M[index + 1], prime, index + 1});
        }
        return M[n - 1];
    }
}