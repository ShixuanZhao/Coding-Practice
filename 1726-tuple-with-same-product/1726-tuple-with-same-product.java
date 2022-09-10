class Solution {
    /*
    For a valid tuple of length 4, [a,b,c,d] it can be arrange in 8 different ways.
Construct a frequency map, where
key is product of two distinct numbers in the array and
value is number of such pairs
If the number of such pairs is greater than one, those elements can be use to for a valid [a,b,c,d] tuple.
Increment the count, and in the final result multiply 8 becos each such count can have different ways.
    */
    public int tupleSameProduct(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length - 1; i++){
            
            for(int j = i + 1; j < nums.length; j++){
                
                int val = nums[i] * nums[j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        
        for(int key : map.keySet()){
            
            int val = map.get(key);
            
            if(val > 1){
                //C3,2 val * (val - 1) / 2 is the combanation problem, for each have 8 permutation
                res += val * (val - 1) * 4;    // (val * (val - 1) / 2) * 8
            }
        }
        
        return res;
    }
}
