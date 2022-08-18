class Solution {
    /*
    Let's think about how a character can be found as a unique character.
Think about string "XAXAXXAX" and focus on making the second "A" a unique character.
We can take "XA(XAXX)AX" and between "()" is our substring.
We can see here, to make the second "A" counted as a uniq character, we need to:
insert "(" somewhere between the first and second A
insert ")" somewhere between the second and third A
For step 1 we have "A(XA" and "AX(A", 2 possibility.
For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.
So there are in total 2 * 3 = 6 ways to make the second A a unique character in a substring.
In other words, there are only 6 substring, in which this A contribute 1 point as unique string.
Instead of counting all unique characters and struggling with all possible substrings,
we can count for every char in S, how many ways to be found as a unique char.
We count and sum, and it will be out answer.
Explanation
index[26][2] record last two occurrence index for every upper characters.
Initialise all values in index to -1.
Loop on string S, for every character c, update its last two occurrence index to index[c].
Count when loop. For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
For the first "A": (6-3) * (3-(-1))"
For the second "A": (9-6) * (6-3)"
For the third "A": (N-9) * (9-6)"
Complexity
One pass, time complexity O(N).
Space complexity O(1).
逆向思维:寻找每个字母对整体的贡献，对于同一个字母出现在不同的位置，找这些不同位置的左右边界，排列组合left * right
    */
     public int uniqueLetterString(String S) {
         //last last and last appreceing index for each letter
         int[][] index = new int[26][2];
         int res = 0;
         //at first, all index should be -1
         for (int i = 0; i < 26; i++) {
             Arrays.fill(index[i], -1);
         }
         int n = S.length();
         //iterate, find c, and find last last c and last c, expand from the last c
         for (int i = 0; i < S.length(); i++) {
             int c = S.charAt(i) - 'A';
             res += (i - index[c][1]) * (index[c][1] - index[c][0]);
             index[c] = new int[] {index[c][1], i};
         }
         //for last apprience of each letter
         for (int i = 0; i < 26; i++) {
             res += (n - index[i][1]) * (index[i][1] - index[i][0]);
         }
         return res;
    }
}