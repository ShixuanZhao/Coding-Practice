class Solution {
//     The idea here is basically implement a String comparator to decide which String should come first during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
// For example:

// String s1 = "9";
// String s2 = "31";

// String case1 =  s1 + s2; // 931
// String case2 = s2 + s1; // 319

// Apparently, case1 is greater than case2 in terms of value.
// So, we should always put s1 in front of s2.

    public String largestNumber(int[] num) {
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
                //大的在前小的在后
				return s2.compareTo(s1); // 
		    }
	     };
		//[3,30,34,5,9]
        //after sorting:9 5 34 3 30
		Arrays.sort(s_num, comp);
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
        //000000, return 0
		if(s_num[0].charAt(0) == '0')
			return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	        sb.append(s);
		
		return sb.toString();
		
	}
}