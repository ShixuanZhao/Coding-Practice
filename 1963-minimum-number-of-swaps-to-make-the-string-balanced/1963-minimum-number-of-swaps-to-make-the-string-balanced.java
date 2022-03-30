class Solution {
	// First cancel out all the valid pairs, then you will be left with something like]]][[[, 
	// and the answer will be ceil(m/2). Where m is the number of pairs left.
    /*
    mismatch = 2
    ))(( swap index 0 and index 3
    ()() 1 step
    */
    public int minSwaps(String s) {
        Stack <Character> stack = new Stack ();
        int mismatch = 0;
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch == '[')
                stack.push (ch);
            else {
                if (!stack.isEmpty ())
                    stack.pop ();
                else 
                    mismatch++;
            }
        }
        return (mismatch + 1) / 2;
    }
}