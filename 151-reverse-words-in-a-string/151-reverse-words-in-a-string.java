class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        reverse(arr, 0, n - 1);
        reverseWord(arr);
        return cleanSpace(arr);
    }
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    private void reverseWord(char[] arr) {
        int start = 0;
        int n = arr.length;
        int i = 0;
        while (i < n) {
            while (i < n && arr[i] == ' ') {
                i++;
            }
            start = i;
            while (i < n && arr[i] != ' ') {
                i++;
            }
            reverse(arr, start, i - 1);
        }
    }
    
    private String cleanSpace(char[] arr) {
        //i is the slow, j is the fast
        int i = 0;
        int j = 0;
        int n = arr.length;
        while (j < n) {
            while (j < n && arr[j] == ' ') {
                j++;
            }
            while (j < n && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }
            //not add ' ' at tail
            if (j < n) {
                arr[i++] = ' ';
            }
            
        }
        //trim the tail space
        if (i - 1 >= 0 && arr[i - 1] == ' ') {
            i--;
        }
        return new String(arr).substring(0, i);
    }
}