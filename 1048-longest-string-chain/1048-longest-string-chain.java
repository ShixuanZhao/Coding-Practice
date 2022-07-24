class Solution {
    /*
    //combanation 
    //longest inscreasing subsequence + helper fuc 判断predecessor
    //逆向思维：删除一个，从后往前从长变短的一个chain
    //M[i]:the longest chain starting from index i(begin to delete) 以i结尾的最长chain
    //M[i] = MAX(M[j] + 1) words[j] can be obtained by deleting a letter from words[i]
    //sort by length, liear scan the words have smaller length
    //i scan from left to right, j scan from i - 1
    */
    //M[i]: the longest chain ending at index i(including)
    //M[i] = Math.max(M[j]) words[j] and words[i] are predecessor
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] M = new int[n];
        int res = 1;
        Arrays.fill(M, 1);
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (int i = 1; i < n; i++) {
             //长度相同的word相邻，所以保证相邻重复的可以跳过
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isP(words[i], words[j])) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            //System.out.println(M[i]);
            res = Math.max(res, M[i]);
        }
        return res;
    }
    
    /*
    bda
       i
    bdca
        j
     cnt:1
    */
    private boolean isP(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == n2) {
            return false;
        }
        //s1 is the longer one
        int i = 0;
        int j = 0;
        //the number of letter in s2 has been ignored
        int cnt = 0;
        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                if (++cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    //M2: dfs + memo
    // record all the letter in the words dict
    // Set<String> set = new HashSet<>();
    // //memo
    // Map<String, Integer> map = new HashMap<>();
    // public int longestStrChain(String[] words) {
    //     for (String word : words) {
    //         set.add(word);
    //     }
    //     int res = 0;
    //     for (String word : words) {
    //         res = Math.max(res, dfs(word));
    //     }
    //     return res;
    // }
    
//     //以word为终点开始删除的最长chain
//     private int dfs(String word) {
//         //base case
//         if (word.length() == 0 || !set.contains(word)) {
//             return 0;
//         }
//         if (map.containsKey(word)) {
//             return map.get(word);
//         }
//         int res = 0;
//         //delete one letter each time
//         for (int i = 0; i < word.length(); i++) {
//             StringBuilder sb = new StringBuilder(word);
//             sb.deleteCharAt(i);
//             res = Math.max(res, 1 + dfs(sb.toString()));
//         }
//         return res;
//     }
}