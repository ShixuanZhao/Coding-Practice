class Solution {
//     public void wiggleSort(int[] nums) {
//         for(int i=0;i<nums.length;i++)
//             if(i%2==1){
//                if(nums[i-1]>nums[i]) swap(nums, i);
//             }else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i);
//     }
    
//     //swap with prev ele
//     public void swap(int[] nums, int i){
//           int tmp=nums[i];
//           nums[i]=nums[i-1];
//           nums[i-1]=tmp;
//     }
    
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);//可以自己写快速排序.
        //not in place
        int[]array=new int[nums.length];
        int k=nums.length-1;
        //index is odd, is peak
        for(int i=1;i<nums.length;i+=2)
        {
            array[i]=nums[k--];
        }
        //index is even, is botton
        for(int i=0;i<nums.length;i+=2)
        {
            array[i]=nums[k--];
        }

        // nums = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            nums[i] = array[i];
        }
    }
}