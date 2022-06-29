class Solution {
//     Sort both arrays and get their sums respectively: sum1 and sum2;
// Use two pointers in the two arrays; one pointer from left to right in the array with smaller sum and the other from right to left in the array with bigger sum;
// In the array with smaller sum, check the difference between current element with 6; in the array with bigger sum, check the difference between current element with 1; choose the larger difference and add it to sum1.
// repeat 3 till sum1 >= sum2.
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for(int n: nums1)
            sum1 += n;
        
        for(int n: nums2)
            sum2+=n;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int diff = Math.abs(sum1 -sum2);
        
        if(diff == 0)
            return 0;
        
        if(sum1 > sum2){
            return count(nums1, nums2, diff);
        }
        
        return count(nums2, nums1, diff);
        
    }
    
    
    int count(int[] nums1, int[] nums2, int diff){
        // nums1 bigger
        
        int i = nums1.length-1;
        int j= 0;
        int res = 0;
        while(i >= 0 && j < nums2.length){
            int a = nums1[i] - 1;
            int b = 6 - nums2[j];
            if(a >= b){
                diff -= a;
                i--;
            } else {
                diff -= b;
                j++;
            }
            res++;
            if(diff <= 0)
                return res;
        }
        
        while(i >= 0){
            int a = nums1[i--] - 1;
             diff -= a;
             res++;
            if(diff <= 0)
                return res;
        }
        
        while(j < nums2.length){
            int a = 6 - nums2[j++];
            diff -= a;
            res++;
            if(diff <= 0)
                return res;
        }
        
        return -1;
    }
}