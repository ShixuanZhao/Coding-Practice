class Solution {
//     let a = nums[i] and b= nums[nums[i]]
// let nums=[0,2,1,5,3,4]
// if a = nums[3] = 5 then b = nums[nums[3]] = nums[5] = 4
// a+nb = 5 + 64 = 29
// 29%n = 29 % 6 = 5 = a; so formula for a = (a+nb)%n
// 29/n = 29/6 = 4 = b ; so formula for b = (a+nb)/n
    
    //Can you solve it without using an extra space (i.e., O(1) memory)?
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            // this is done to keep both old and new value together. 
            // going by the example of [5,0,1,2,3,4]
            // after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
            // now for next index calulation we might need the original value of num[0] which can be obtain by num[0]%6 = 29%6 = 5;
            // if we want to get just he new value of num[0], we can get it by num[0]/6 = 29/6 = 4
            nums[i] = nums[i] + n*(nums[nums[i]] % n);
        }
        
        for(int i=0; i<n; i++){
            nums[i] = nums[i]/n;
        }
        
        return nums;
    }
}