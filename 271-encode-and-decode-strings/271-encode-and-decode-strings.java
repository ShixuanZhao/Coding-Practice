public class Codec {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        //s: 5/Hello5/World
        while(i < s.length()) {
            //i is the from index, representing the index position to start the search from
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            ret.add(s.substring(slash + 1, i));
        }
        return ret;
    }
    //Wrong, cannot pass "" case because for empty string, it would not go into line41
//      public String encode(List<String> strs) {
//          StringBuilder sb = new StringBuilder();
//         for(String s : strs) {
//             sb.append(s).append('/');
//         }
//          sb.deleteCharAt(sb.length() - 1);
//          System.out.println(sb.toString());
//         return sb.toString();
//      }
    
//      public List<String> decode(String s) {
//         List<String> res = new ArrayList<>();
//          String[] arr = s.split("/");
//          System.out.println(Arrays.toString(arr));
//          for (int i = 0; i < arr.length; i++) {
//              res.add(arr[i]);
//          }
//          return res;
//      }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));