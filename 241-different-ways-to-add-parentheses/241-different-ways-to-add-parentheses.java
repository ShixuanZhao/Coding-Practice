class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        int temp = 0;
                        if (c == '+') {
                            temp = l + r;
                        } else if (c == '-') {
                            temp = l - r;
                        } else if (c == '*') {
                            temp = l * r;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
    
    // private List<Integer> helper(List<Integer> res, int lo, int hi, String expression, int[] index) {
    //     // if (lo == hi) {
    //     //     System.out.println(expression.charAt(lo) - '0');
    //     //     res.add(expression.charAt(lo) - '0');
    //     //     System.out.println(res);
    //     //     return res;
    //     // }
    //     while (index[0] < expression.length()) {
    //         char c = expression.charAt(index[0]++);
    //         if (c == '+' || c == '-' || c == '*') {
    //             List<Integer> left = helper(res, lo, index[0] - 1, expression, index);
    //             List<Integer> right = helper(res, index[0] + 1, hi, expression, index);
    //             for (int l : left) {
    //                 for (int r : right) {
    //                     int temp = 0;
    //                     if (c == '+') {
    //                         temp = l + r;
    //                     } else if (c == '-') {
    //                         temp = l - r;
    //                     } else if (c == '*') {
    //                         temp = l * r;
    //                     }
    //                    System.out.println(temp);
    //                     res.add(temp);
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
}