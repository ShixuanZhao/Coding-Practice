class Solution {
    /*
        clarify: if needle is empty, return 0
                    not found: return -1;
                    found: return index
        high level: linear scan the haystack, try each possible start(outer loop)
        01234     inner loop: try each index in needle
        hello                  if all the letter has been matched, return i
          i   return 2           if one letter is not matched, break
                                try next start point
         needle = "ll"
                   j
    */
    // public int strStr(String haystack, String needle) {
    //     if (needle.length() > haystack.length()) {
    //         return -1;
    //     }
    //     for (int i = 0; i <= haystack.length() - needle.length(); i++) {
    //         int j = 0;
    //         for (; j < needle.length(); j++) {
    //             if (haystack.charAt(i + j) != needle.charAt(j)) {
    //                 break;
    //             }
    //         }
    //         if (j == needle.length()) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // long MOD = (long)Math.pow(2, 32);
    // public int strStr(String haystack, String needle) {
    //     // base case check
    //     if(haystack == null || needle == null || needle.length() > haystack.length()){
    //         return -1;
    //     }
    //     if(needle.length() == 0){
    //         return 0;
    //     }
    //     int len1 = haystack.length(), len2 = needle.length();
    //     // hashcode for needle
    //     long hashCode = 0;
    //     for(int i = 0; i < len2; i++){
    //         hashCode = hashCode * 26 + (needle.charAt(i) - 'a' + 1);
    //     }
    //     // hashcode for current sliding window.
    //     long curCode = 0;
    //     for(int i = 0; i < len1; i ++){
    //         if(i < needle.length()){
    //             curCode = curCode * 26 + (haystack.charAt(i) - 'a' + 1);
    //             if(curCode == hashCode){
    //                 return i - len2 + 1;
    //             }
    //         }else{
    //             int offset = haystack.charAt(i - len2) - 'a' + 1;
    //             curCode = curCode - (long)Math.pow(26, len2 - 1) * offset;
    //             curCode = curCode * 26 + (haystack.charAt(i) - 'a' + 1);
    //             if(curCode == hashCode) return i - len2 + 1;
    //         }
    //     }
    //     return -1;
    // }
    
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        int[] hashM = new int[m];
        int[] hashN = new int[n];
        //convert string to int[]
        for (int i = 0; i < m; i++) {
            hashM[i] = haystack.charAt(i) - 'a';
        }
        for (int i = 0; i < n; i++) {
            hashN[i] = needle.charAt(i) - 'a';
        }
        int base = 26;
        long MOD = (long)Math.pow(2, 32);
        //the first sequence hash of hashM[] and hashN[]
        long hash1 = 0;
        for (int i = 0; i < n; i++) {
            hash1 = (hash1 * base + hashM[i]) % MOD;
        }
        long hash2 = 0;
        for (int i = 0; i < n; i++) {
            hash2 = (hash2 * base + hashN[i]) % MOD;
        }
        if (hash1 == hash2) {
            return 0;
        }
        long adjustedWeight = 1;
        for (int i = 1; i <= n; ++i) adjustedWeight = (adjustedWeight * base) % MOD;
        for (int i = 1; i < m - n + 1; i++) {
            hash1 = (hash1 * base - hashM[i - 1] * adjustedWeight + hashM[i + n - 1]) % MOD;
            if (hash1 == hash2) {
                return i;
            }
        }
        return -1;
    }
}