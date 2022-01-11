class Solution {
    /* 
        012
        aaa
        we select each position as central point, and we will expand from it and check prlindrome
        a (a) a   res:2   odd l = r index = 1
        l     r   terminate:out of bound
        
        a(aa) expand from the two middle point odd length  
          lr
    */
    //中心扩散法
    //如果考虑去重并且返回结果，substring之后放入set里
    public int countSubstrings(String s) {
        int n = s.length();
        int[] res = new int[1];
        for (int i = 0; i < n; i++) {
            expand(s, i , i, res); //odd length
            expand(s, i , i + 1, res);//even length
        }
        return res[0];
    }
    
    private void expand(String s, int left, int right, int[] res) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res[0]++;
            left--;
            right++;
        }
    }
}