class Solution {
    /*
    When checking half, we need to ensure that the current number is even, else we will get wrong anwer like in the case of 3 and 7 being in the input. Here for 7, 7/2 would give 3 (not 3.5) which is present in the HashSet but not what we need.
    */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            //!!num % 2 == 0
            if (set.contains(num * 2) || num % 2 == 0 && set.contains(num / 2)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}