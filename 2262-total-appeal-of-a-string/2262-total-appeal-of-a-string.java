class Solution {
    //注意是distinct不是unique，意思是aaa只能算1个，但是不是unique，为0. 828是算unique
    /*
    Solution3: Count contirbution for each character
This solution is more like what we do for 828. Count Unique Characters of All Substrings of a Given String.
You can take 828 as an another chanllendge to practice more.
In a substring, multiple same character only get one point.
We can consider that the first occurrence get the point.
Now for each character, we count its countribution for all substring.
For each character s[i],
the substring must start before s[i] to contain s[i]
and need to end after the last occurrence of s[i],
otherwise the last occurrence of character s[i] will get the socre.
把每个出现的A当做第一个A，所以对于起点有限制 ...A...A....A...
In total, there are i - last[s[i]] possible start position,
and n - i possible end position,
so s[i] can contribute (i - last[s[i]]) * (n - i) points.
From this formula, we can also the difference between problem 2262 and 828.
Complexity: Time O(n), Space O(26)
    */
    public long appealSum(String s) {
        int last[] = new int[26];
        Arrays.fill(last, -1);
        long res = 0, n = s.length();
        for (int i = 0; i < s.length(); ++i) {
            res += (i - last[s.charAt(i) - 'a']) * (n - i);
            last[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}