class Solution {
    /*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
interval starts from 2 * numRows - 2 and decrease by 2. (As same as the step1 in @HelloKenLee solution).
In the while loop, i is 0 means we are in the first row and interval is 0 means we reach the last row. In both cases, we just need to avoid appending repeated characters. Otherwise, we append 2 characters.
*/
    public String convert(String s, int numRows) {
        if(numRows == 1)    return s;
        StringBuilder b = new StringBuilder();
        int interval = 2 * numRows - 2;
        int n = s.length();
        for(int i = 0; i < numRows; i++){
            int j = i;
            while(j < n){
                if(interval != 0)
                    b.append(s.charAt(j));
                j += interval;
                if(i != 0 && j < n)
                    b.append(s.charAt(j));
                j += 2 * i;
            }
            interval -= 2;
        }
        return b.toString();
    }
}