class Solution {
    public int numSplits(String s) {
//         If we have a string aabbc

// Then prefix[] will contain --> [1, 1, 2, 2, 3]
// The suffix[] will contain --> [3, 3, 2, 2, 1]

// if we split the string after 3rd position (let's say) then the split string will be "aab" 
// and "bc". Here i == 3 and prefix[i-1] == suffix[i]
        Set<Character> unique = new HashSet<>();
         int n = s.length();
         int[] prefix = new int[n];
         int[] suffix = new int[n];
         for(int i=0; i<n; i++) {
                unique.add(s.charAt(i));
                prefix[i] = unique.size();
         }
        unique.clear();
        for(int i=n-1; i >= 0; i--) {
              unique.add(s.charAt(i));
              suffix[i] = unique.size();
        }
    
       int ans = 0;
        for(int i=0; i<n - 1; i++) {
              if(prefix[i] == suffix[i + 1]) {
                    ans++;
              }   
        }
       return ans;
    }
}