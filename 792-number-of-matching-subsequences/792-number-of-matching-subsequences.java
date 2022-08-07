class Solution {
//     //brute force, TLE
//     //T = O(words.length∗(S.length+words[i].length))
//     public int numMatchingSubseq(String s, String[] words) {
//         if (words == null || words.length == 0) {
//             return 0;
//         }
//         int res = 0;
//         for (String cur : words) {
//             if (isSub(s, cur)) {
//                 res++;
//             }
//         }
//         return res;
//     }
    
//     private boolean isSub(String l, String s) {
//         int m = l.length();
//         int n = s.length();
//         int i = 0;
//         int j = 0;
//         while (i < m && j < n) {
//             if (l.charAt(i) == s.charAt(j)) {
//                 i++;
//                 j++;
//             } else {
//                 i++;
//             }
//         }
//         return j == n;
//     }
    
    /*
    First, we store all characters' positions of input.
For example: input = "abacbca" ---> POS = ['a', 'b', 'c'] = [ [0,2,6], [1,4], [3,5] ]

Second, while iterating words, for each character of each word, we check if we can choose a position from POS, and the position must follow an increasing order.
For example: word = "acb"
'a' we choose 0
'c' we choose 3
'b' we choose 4
[0,3,4] is an increasing order, so "acb" is a subsequence of our input.

Third, we store the position of current iterating character in a variable cur. The next iteration, we will chose the position so that it's value > cur by using Binary Search
Time complexity is O(mklog(n) where
n is the length of s,
m is the length of words,
k is the largest length of word.
"abcde"
["a","bb","acd","ace"]
    */
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        List<Integer>[] arr = buildPosArr(s);
        int res = 0;
        for (String s1 : words) {
            int index = 0;
            for (int i = 0; i < s1.length(); i++) {
                index = findUpperIndex(arr[s1.charAt(i) - 'a'], index);
                if (index == -1) {
                    break;
                }
                //do not forget
                index++;
            }
            if (index != -1) {
                res++;
            }
        }
        return res;
    }
    
    //// build an array with chars position of each char in S
    private List<Integer>[] buildPosArr(String s) {
        //generic array creation like this is false
        //List<Integer>[] res = new List<Integer>[26];
        List<Integer>[] res = new List[26];
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] == null) {
                res[s.charAt(i) - 'a'] = new ArrayList<>();
            }
            res[s.charAt(i) - 'a'].add(i);
        }
        return res;
    }
    
    //find the upper val >= target
    //[0,2,6] target:1 return 2
       // l 
       //   m
       //   r
    private int findUpperIndex(List<Integer> list, int target) {
        //!!
        if (list == null) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
       if (list.get(left) >= target) {
           return list.get(left);
       } else if (list.get(right) >= target) {
           return list.get(right);
       } else {
           return -1;
       }
    }
}