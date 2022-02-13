class Solution {
    /*
        input:string output:int
        clarify:aaaa
        return 1
        abcabcbb  return 3
        high level: maintain a sliding window[left, right] 
        ds:set record the unique element in the window
        interate each letter in the string
        case1:the right is not in the set, add the right to set, update the maxLen, move the right pointer;
        case2:right is in the set,  move the left pointer, move the left ele from set 
        s = "a b c a b c b b"   set: c a b maxLen:3
                 l
                     r
        follow up: if there are only lower case letter, we can use a boolean array which size is 26
    */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            //case1
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                //case2
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
        // if (s == null || s.length() == 0) {
        //     return 0;
        // }
        // boolean[] letterInWindow = new boolean[26];
        // int left = 0;
        // int right = 0;
        // int maxLen = 0;
        // while (right < s.length()) {
        //     //case1
        //     char c = s.charAt(right);
        //     if (!letterInWindow[c - 'a']) {
        //         letterInWindow[c - 'a'] = true;
        //         maxLen = Math.max(maxLen, right - left + 1);
        //         right++;
        //     } else {
        //         //case2
        //         letterInWindow[s.charAt(left) - 'a'] = false;
        //         left++;
        //     }
        // }
        // return maxLen;
    }
}