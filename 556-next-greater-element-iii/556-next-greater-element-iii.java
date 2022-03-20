class Solution {
    public int nextGreaterElement(int n) {
        // The same as : leetcode 31 Next Permutation, O(n)
        char[] number = (n + "").toCharArray();
        int i = -1;
        //1. find backwards
        for(i = number.length - 1; i > 0; i--)
            if(number[i - 1] < number[i])
                break;
        if(i == 0)
            return -1;
        //2. first, second
        int first = i - 1, second = i;
        //3. find the next greater than first, backward
        for(i = number.length - 1; i > first; i--) {
            if(number[i] > number[first]) {
                char temp = number[i];
                number[i] = number[first];
                number[first] = temp;
                break;
            }
        }
        //4. reverse after second
        reverse(number, second);
        
        //5. Transform back
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
        
    }
    
    private void reverse(char[] a,int i)//reverse the number after the number we have found
    {
        int first = i;
        int last = a.length-1;
        while(first<last)
        {
            char t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}