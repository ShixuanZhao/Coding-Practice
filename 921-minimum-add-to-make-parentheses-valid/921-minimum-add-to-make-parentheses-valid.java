class Solution {
    /*
    ())
      i
    left:1   right:0
    */
    public int minAddToMakeValid(String s) {
        //rolling state 平衡的思路，遇到左括号状态+1遇到右括号状态-1
        //left:需要弥补的左括号的数量， right需要的右括号
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //需要一个右括号来弥补
                right++;
            } else {
                if (right > 0) {
                    right--; //找到一个匹配的pair，还债
                } else {
                    left++; //右括号太多了，需要左括号还弥补
                }
            }
        }
        return left + right;
    }
}