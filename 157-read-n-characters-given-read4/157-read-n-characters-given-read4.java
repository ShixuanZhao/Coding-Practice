/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     
     Understand how read4() works, Initially, I thought it takes input buf as the parameter. But actually, *buf is just as the name refers, it's a buffer char array of size 4.
Realize the corner case where buf = "abcdef", n = 5. The last iteration within the while loop gets count = 2, while we only need 1 last character. This is why we need to compare "count" with "n - total".
If the length of buf can be divided by 4, then we need this check if (count == 0) break; to terminate the loop
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int total = 0;
        while (total < n) {
            int count = read4(temp);
            count = Math.min(count, n - total);
            if (count == 0) break;
            for (int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}