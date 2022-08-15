class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    //Normalise a string to a standard pattern.
    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
    
//     public List<String> findAndReplacePattern(String[] words, String pattern) {
//         List<String> result = new ArrayList();
//         if(words == null || pattern ==null){
//             return result;
//         }
        
//         for(String word : words) {
//             if(isMatch(word, pattern)){
//                 result.add(word);
//             }
//         }
//         return result;
//     }
//     private boolean isMatch(String word, String pattern) {
//         if(word.length() != pattern.length()){
//             return false;
//         }
//         Map<Character, Character> aToB = new HashMap();
//         Map<Character, Character> bToA = new HashMap();
        
//         for(int i=0; i<word.length(); i++) {
//             if(aToB.containsKey(word.charAt(i))){
//                 if(aToB.get(word.charAt(i)) != pattern.charAt(i)){
//                     return false;
//                 }
//             } else {
//                 if(bToA.containsKey(pattern.charAt(i))){
//                     return false;
//                 }
//                 aToB.put(word.charAt(i), pattern.charAt(i));
//                 bToA.put(pattern.charAt(i), word.charAt(i));
//             }
//         }
//         return true;
//     }
}