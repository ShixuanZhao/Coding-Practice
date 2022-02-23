class Solution {
    /*
        我们可以将字符串 ss 按照 00 和 11 的连续段分组，存在counts 数组中，例如 s =00111011，可以得到这样的counts 数组：counts={2,3,1,2}。

这里counts 数组中两个相邻的数一定代表的是两种不同的字符。假设counts 数组中两个相邻的数字为u 或者 v，它们对应着 u 个 0和 v 个 1，或者 u 个 1 和 v 个 0。它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。

我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
eg.the pair(2, 3) min(2, 3) = 2  0011 can produce 0011 and 01 both of them would be added to the ans
    s =00111011   cnt:2
         i         temp:1
         优化：对于某一个位置 i，其实我们只关心 i - 1位置的 counts 值是多少，所以可以用一个last 变量来维护当前位置的前一个位置，这样可以省去一个 counts 数组的空间。
         
 public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
    
    */
    public int countBinarySubstrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
       List<Integer> numOfSameEle = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int cnt = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                cnt++;
            }
            numOfSameEle.add(cnt);
        }
        int res = 0;
        for (int j = 1; j < numOfSameEle.size(); j++) {
            res += Math.min(numOfSameEle.get(j - 1), numOfSameEle.get(j));
        }
        return res;
    }
}