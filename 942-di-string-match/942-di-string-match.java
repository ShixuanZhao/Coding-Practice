class Solution {
    /*
    suppose S.length = 4 and S="IDID", so the numbers we need to fill in the result set is 0 1 2 3 4
if the current char is 'I', we want to pick a number in the current potential options (0-4) that satisfies all scenarios in next loop, it should be the smallest one, which is 0
now the rest of options are 1 2 3 4
if the current char is 'D', again, we want to make sure that FOR EVERY NUMBER WE PICK IN NEXT ROUND will satisfy a[current] > a[current+1], then pick the largest value in 1 2 3 4, which is 4
then set becomes [1 2 3], we repeat the above
the thinking is really similar to "greedy" that we pick some number that can most satisfy the cases for next loop
    "IDID" 0-4
        i
    [0,1,2,3,4]
         l
         r
    0 4 1 3 2
    */
    public int[] diStringMatch(String s) {
        //two pointer+greedy
        int n = s.length();
        int[] res = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? left++ : right--;
        }
        res[n] = left;
        return res;
    }
}