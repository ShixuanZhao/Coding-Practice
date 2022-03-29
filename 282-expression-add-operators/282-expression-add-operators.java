class Solution {
    /*
    This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right? If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take it out from the existing eval. You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4).
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(num, target, sb, 0, 0, 0, res);
        return res;
    }
    //prevNum is used to multiply
    private void dfs(String num, int target, StringBuilder sb, int index, long prevRes, long prevNum, List<String> res) {
        if (index == num.length()) {
            if (prevRes == target) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            //exclude the leading zero case: like 022
            //only 0 is ok
            if (num.charAt(index) == '0' && i != index) {
                break;
            }
            //from index to i(inclusive) is the cur num
            long cur = Long.valueOf(num.substring(index, i + 1));
            int len = sb.length();
            //fisrt num do not to do calculation
            if (index == 0) {
                dfs(num, target, sb.append(cur), i + 1, cur, cur, res);
                sb.setLength(len);
            } else {
                dfs(num, target, sb.append("+").append(cur), i + 1, prevRes + cur, cur, res);
                sb.setLength(len);
                dfs(num, target, sb.append("-").append(cur), i + 1, prevRes - cur, -cur, res);
                sb.setLength(len);
                dfs(num, target, sb.append("*").append(cur), i + 1, prevRes - prevNum + cur * prevNum, cur * prevNum, res);
                sb.setLength(len);
            }
        }
    }
}