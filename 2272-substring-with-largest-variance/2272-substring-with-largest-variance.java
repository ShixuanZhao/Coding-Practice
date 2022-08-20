/**
For every possible character pair a(min freq) & b(max freq),
find the substring with the max differenct between the freq of a & b which can be done using kadanes algorithm.

We can think about it as finding the maximum subarray with a = -1 and b = 1 and other characters = 0. But we should have at least one occurrence of a.
53. Maximum Subarray
**/
class Solution {
    
    public int largestVariance(String s) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0)+1);
        }
        int variance = 0;
        //Iterate through unique characters
        for (Character primaryChar: charCount.keySet()) {
            for  (Character secondaryChar: charCount.keySet()) {
                // We need a unique character  pair to compute variance
                if (primaryChar == secondaryChar) { continue; }
                //we have to make sure for every candidate substring, there must be at least one a. A substring with all b is not a valid one 确保至少有一个secondaryChar
                int secondaryCharCount = charCount.get(secondaryChar);
                int primaryFreq = 0;
                int secondaryFreq = 0;              
                
                for (int i = 0; i < s.length(); i++) {
                    Character currChar = s.charAt(i);
                    if (currChar == primaryChar) {
                        primaryFreq++;  
                    }
                    if (currChar == secondaryChar) {
                        secondaryFreq++;
                        secondaryCharCount--;
                    }
                    // Variance only computed if we have already seen both a primary
                    // and a secondary character
                    if (primaryFreq > 0 && secondaryFreq > 0 && primaryFreq > secondaryFreq) {                    
                        variance  = Math.max(variance, (primaryFreq - secondaryFreq));
                    }
                    // We reset our index so we are ignoring the substring which will
                    // impact our variance negatively
                    if (primaryFreq < secondaryFreq && secondaryCharCount > 0) {                      
                        primaryFreq = 0;
                        secondaryFreq = 0;                       
                    }
                }
                
            }
        }
        return variance;
    }   
}