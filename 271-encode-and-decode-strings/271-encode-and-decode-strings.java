public class Codec {
/*
We ought to define a delimiter to separate words within the list, however, any character delimiter can be part of the original word. Thus, we use lengthOfStr + : to delimit a word.

Take ["a:b", "c"] for example, the encoded word is s = "3:a:b1:c".
*/
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        int start = 0;
        //3/app5/apple
        while (start < s.length()) {
            //index of "/"
            int index = s.indexOf("/", start);
            int size = Integer.valueOf(s.substring(start, index));
            start = index + size + 1;
            res.add(s.substring(index + 1, start));
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));