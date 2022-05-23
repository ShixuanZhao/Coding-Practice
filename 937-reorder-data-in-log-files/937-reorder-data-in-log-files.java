class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
           //make sure the type, letter or digit
            //a[0] is the type, and a[1] is the content
            //2 is the size
            String[] a1 = a.split(" ", 2);
            String[] b1 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(a1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(b1[1].charAt(0));
            if (isDigit1 && isDigit2) {
                return 0;
            } else if (!isDigit1 && !isDigit2) {
                int temp = a1[1].compareTo(b1[1]);
                if (temp != 0) {
                    return temp;
                } else {
                    //compare by type
                    return a1[0].compareTo(b1[0]);
                }
            } else if (isDigit1) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}