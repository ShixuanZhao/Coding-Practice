class Solution {
    /*
    If negative: sort descending, excluding the sign.
If positive: sort ascending
Find first non-zero number (e.g. 000237)
Swap it with the first number (e.g. 200037)
    */
    public long smallestNumber(long num) {
        if(num == 0){
            return 0;
        }
        boolean isNegative = num < 0;
        num  = num < 0 ? num * -1 : num;
        
        char[] c = String.valueOf(num).toCharArray();
        Arrays.sort(c);
        /*
        310->sorting:013
                     ij
        swap:103
        */
        if (!isNegative) {
            //find the first non-zero
            int i = 0;
            while (i < c.length && c[i] == '0') {
                i++;
            }
            //if not negative we need to find out the first non-leading zero then swap with first zero
            char temp = c[0];
            c[0] = c[i];
            c[i] = temp;
            //System.out.println(new String(c));
            return Long.valueOf(new String(c));
        } else {
            //-7605 -> 0567 ->reverse and add"-"
            StringBuilder sb = new StringBuilder(new String(c));
            sb.reverse().insert(0, "-");
            //System.out.println(sb.toString());
            return Long.valueOf(sb.toString());
        }
    }
}