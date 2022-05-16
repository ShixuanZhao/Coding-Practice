class Solution {
    /*
    x = 0 or 1 return x
    use recursion: pow(x, n) n > 0 
    n < 0   1 / pow(x, -n)
    n = 0   1
    n > 0  pow(x, n)
    pow(x, n) n > 0 
    temp = pow(x, n / 2)
    n is even: res = temp * temp
    n is odd: res = temp * temp * x
    */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = pow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}