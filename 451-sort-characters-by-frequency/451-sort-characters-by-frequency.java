class Solution {
//     O(n) to build the frequency map of size K.
// O(k log k) to build the heap from frequencies of k unique characters & retrieve these characters in sorted order.
// O(n) to rebuild the string from polled values of heap. (it can look more because of two nested loops but realise that your total work in the inner loops is appending n characters to an empty StringBuffer regardless of what's the frequency distribution. Another way to implement/think about time complexity of this program could be to separate the two loops by storing values returned by heap in a separate array of size k and then using this array + frequency map to rebuild string in O(n)).
// Hence,
// TC = O(n + k log k + n) =.O(n + k log k) = O(n) (ignoring k log k as a 2 byte char can have only 256 unique values which makes O(k log k) << O(n) for bigger values of n.
    //according to user "orxanb", O(nlogm), m is the distinguish character, can be O(1) since only 26 letters. So the overall time complexity should be O(n), the same as the buck sort with less memory use.
//     public String frequencySort(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         for (char c : s.toCharArray())
//             map.put(c, map.getOrDefault(c, 0) + 1);
        
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//         pq.addAll(map.entrySet());
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             Map.Entry e = pq.poll();
//             for (int i = 0; i < (int)e.getValue(); i++) 
//                 sb.append(e.getKey());
//         }
//         return sb.toString();
//     }
    
    //we can also use bucket sort. put the character that has same frequency into same bucket
    //bucket sort根据频率排序，bucket的index是freq,value is a list of char
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(c);
        }
        StringBuilder sb = new StringBuilder();
        //i is the freq
        for (int i = s.length(); i >= 1; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
    
//     There is a follow up if you are interested, when same frequency we need to maintain the same sequence as the character show in the original string, the solution is add a index as a secondary sort if the frequency is same, code as below:

//     public static String frequencySort(String s) {
//         Map<Character, int[]> map = new HashMap<>();
//         for (int i = 0; i <s.length(); i++) {
//             char c = s.charAt(i);
//             if (!map.containsKey(c)) map.put(c, new int[]{1, i});
//             else {
//                 int[] freqAndSeq = map.get(c);
//                 freqAndSeq[0]++;
//                 map.put(c, freqAndSeq);
//             }
//         }

//         PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
//                 a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);

//         pq.addAll(map.entrySet());
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             Map.Entry<Character, int[]> e = pq.poll();
//             for (int i = 0; i < e.getValue()[0]; i++)
//                 sb.append(e.getKey());
//         }
//         return sb.toString();
//     }
	
// 	if the same freq, we need to sort by lexicographcal order just update the comparable like this

// PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
//     new Comparator<Map.Entry<Character, Integer>>() {
//         @Override
//         public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
//               if(b.getValue()==a.getValue()){ return (int)a.getKey()-(int)b.getKey();}
//             return b.getValue() - a.getValue();
//         }
//      }
// );
}