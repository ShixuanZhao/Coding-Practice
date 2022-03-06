class Solution {
    /*
        high level:two pointers
        version1 = "1.01", version2 = "1.001"   v1:1     v2:1
                        i                   j
         when i or j meet with ".", calculate the revision.
         compare v1 and v2. if v1 == v2, we skip "." and continue to compare next revision
         if we have traversed all the letters in v1 and v2, and still can not get result, we will return 0
    */
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int v1 = 0;
        int v2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        while (i < len1 || j < len2) {
            //compare each revision(the int val between '.')
            //01 and 001 would be the same 1
            while (i < len1 && version1.charAt(i) != '.') {
                v1 += v1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < len2 && version2.charAt(j) != '.') {
                v2 += v2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }
            //continue to compare
            v1 = 0;
            v2 = 0;
            i++;
            j++;
        }
        return 0;
    }
}