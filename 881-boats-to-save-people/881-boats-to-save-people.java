class Solution {
    /*
    Sort people.
For the current heaviest person, we try to let him go with the lightest person.
As all people need to get on the boat.
If the sum of weight is over the limit, we have to let the heaviest go alone.
No one can take the same boat with him.

At the end of for loop, it may happend that i = j.
But it won't change the result so don't worry about it.

    1 2 2 3 limit = 3
      i     
     j
    */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0;
        //j右边的长度是需要boat的数量
        int j = n - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        return n - j - 1;
    }
}