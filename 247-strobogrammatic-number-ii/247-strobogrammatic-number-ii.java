class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);    
    }
    
//     if n != m, then you can add "0" in front and back
// if n == m, addition of 0 in front and back will not yield a valid number
// Example :
// n = 5 // original request
// 080 - could be done. In next step 10801 makes it a strobogrammatic number.
// if n = 3
// You can't do 080 can't yield a valid number
    private List<String> helper(int curLen, int n){
        if(curLen == 0) return new ArrayList(Arrays.asList(""));
        if(curLen == 1) return new ArrayList(Arrays.asList("1","8","0"));
        List<String> sub = helper(curLen-2, n);
        List<String> cur = new ArrayList();
        for(String s: sub){
            //we cannot add 0 at the begin and end
            //0xxxx0, this happen in the last round of recursion, we we build最外层的时候，curLen == n
            if(curLen != n){
                cur.add("0" + s + "0");
            }
            cur.add("6" + s + "9");
            cur.add("9" + s + "6");
            cur.add("8" + s + "8");
            cur.add("1" + s + "1");	
        }
        return cur;
    }
}