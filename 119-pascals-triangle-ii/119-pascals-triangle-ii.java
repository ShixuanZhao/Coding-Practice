class Solution {
    public List<Integer> getRow(int k) {
        //k is the index
        //res store the previous row
        //error1: 不要用list.set()以为这是O（N）的操作 2。res.set(j, 1)会出错，用set必须先能访问到index，要用add
        // List<Integer> res = new ArrayList<>();
        // if (k < 0) {
        //     return res;
        // }
        // for (int i = 0; i <= k; i++) {
        //     for (int j = 0; j <= i; j++) {
        //         if (j == 0 || j == i) {
        //             res.set(j, 1);
        //         } else {
        //             res.set(j, res.get(j) + res.get(j - 1));
        //         }
        //     }
        // }
        // return res;
        
        //use arr
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 1);
        for (int i = 1; i <= k; i++) {
            for (int j = i - 1; j >= 1; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return Arrays.asList(arr);
    }
}