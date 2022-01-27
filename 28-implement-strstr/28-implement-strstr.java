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
    //古城算法：滚动hash，rabin-karp
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        if (n == 0) return 0;
        if (h == 0 || n > h) return -1;

        // convert string to array of integers
        int[] numsH = new int[h];
        int[] numsN = new int[n];
        for (int i = 0; i < h; i++) numsH[i] = (int)haystack.charAt(i) - (int)'a';
        for (int i = 0; i < n; i++) numsN[i] = (int)needle.charAt(i) - (int)'a';

		// there are 26 letters in English
        int base = 26;
		// needle.length() could be 5 x 10^4 ==>> without modulus, the hash will overflow 
        long modulus = (long)Math.pow(2,32);

        // compute the hash of the first sequence h_0 of haystack
        long hashH = 0;
        for (int i = 0; i < n; i++) hashH = (hashH * base + numsH[i]) % modulus;
        // compute the hash of needle
        long hashN = 0;
        for (int i = 0; i < n; i++) hashN = (hashN * base + numsN[i]) % modulus;

        if (hashH == hashN) return 0;

		// the weight of the first digit in any sequence is base^(n-1)
		// but in LeetCode, the operation of Rolling Hash is in a generalized way, so the weight becomes base^n.
        long adjustedWeight = 1;
        for (int i = 1; i <= n; ++i) adjustedWeight = (adjustedWeight * base) % modulus;

		// Rolling Hash
        for (int start = 1; start < h - n + 1; start++) {
            //remove last digit and add new digit
            hashH = (hashH * base - numsH[start-1] * adjustedWeight + numsH[start + n -1]) % modulus;
            //while (modulus < 0) hashH += modulus;
            if (hashH == hashN) return start;
        }

        return -1;
    }
}