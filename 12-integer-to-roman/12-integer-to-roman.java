class Solution {
    /*
        step1:num: 48 find the largest number(40) that smaller than 48, add the corresponding string("L") to res
        step2:let num = 48 - 40 = 8, and repeat step1 until num == 0 
        num:8 3 2 1 0
        sb:XL V I I I
        在基础版本之上，添加4和9的：900 400 90 40 9 4
    */
    public String intToRoman(int num) {
        final int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] romans = new String[] {"M", "CM", "D","CD", "C" , "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}