class Solution {
     public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();        
        
        // count all chars
        int[] c = new int[256];
        for(int i=0;i<s.length();i++) c[s.charAt(i)]++;

        // count all odd chars        
        for(int i=0;i<c.length;i++) {
            if(c[i]%2!=0) sb.append((char) i);
        }
        
        // if there is more then 1 odd char, return the empty list
        if(sb.length()>1) return res; 

        
        permute(sb, res, c, s.length());
        return res;
    }
    
    
    void permute(StringBuilder sb, List<String> res, int[] c, int len){
        if(sb.length()==len){
            res.add(sb.toString());
            return;
        }
        
        //中心拓展法
        for(int i=0;i<c.length;i++){
            if(c[i]>1){
                c[i]-=2;
                sb.insert(0, (char) i);
                sb.append((char) i);
                
                permute(sb, res, c, len);
                
                // backtrack
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
                c[i]+=2;                
            }
        }
        
    }
}