class Solution {
    //the method similiar to leetcode 821 shortest distance to a character
// Whether be pushed or not, depend on the shortest distance to 'L' and 'R'.
// Also the direction matters.
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        //the force to right
        int[] right = new int[n];
        int[] left = new int[n];
        int lastRight = -1;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                lastRight = i;
            } else if (dominoes.charAt(i) == 'L') {
                lastRight = -1;
            } else {
                if (lastRight != -1) {
                    right[i] = i - lastRight;
                }
            }
        }
        //the force to left
        int lastLeft = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                lastLeft = i;
            } else if (dominoes.charAt(i) == 'R') {
                lastLeft = -1;
            } else {
                if (lastLeft != -1) {
                    left[i] = lastLeft - i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                sb.append('L');
            } else if (c == 'R') {
                sb.append('R');
            } else {
                //c is '.'
                if (left[i] == 0 && right[i] != 0) {
                    sb.append('R');
                } else if (right[i] == 0 && left[i] != 0) {
                    sb.append('L');
                } else if (right[i] < left[i]) {
                    sb.append('R');
                } else if (right[i] > left[i]) {
                    sb.append('L');
                } else {
                    sb.append('.');
                }
            }
        }
        return sb.toString();
    }
}