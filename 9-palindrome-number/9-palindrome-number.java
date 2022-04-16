class Solution {
    public boolean isPalindrome(int x) {
    //compare half of the digits in x, so don't need to deal with overflow.
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);        //even digits and odd digits
    }
}

// When the reversed number overflows, it will becomes negative number which will return false when compared with x.
// public boolean isPalindrome(int x) {
//         if(x < 0) return false;
//         int y = x;
//         int res = 0;
//         while(y != 0) {
//             res = res * 10 + y % 10;
//             y /= 10;
//         }
//         return x == res;
//     }