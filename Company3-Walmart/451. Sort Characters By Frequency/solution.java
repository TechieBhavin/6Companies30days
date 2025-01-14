

// class Solution {
//     public String frequencySort(String s) {
//         Map<Character, Integer> hm = new HashMap<>();
        
//         for (char c : s.toCharArray()) {
//             hm.put(c, hm.getOrDefault(c, 0) + 1);
//         }
        
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
//             (a, b) -> b.getValue() - a.getValue()
//         );
        
//         pq.addAll(hm.entrySet());
        
//         StringBuilder result = new StringBuilder();
//         while (!pq.isEmpty()) {
//             Map.Entry<Character, Integer> entry = pq.poll();
//             result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
//         }
        
//         return result.toString();
//     }
// }

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        TreeMap<Integer, List<Character>> r = new TreeMap<>(Collections.reverseOrder());
        StringBuilder ss = new StringBuilder();

        for (char a : s.toCharArray())
            mp.put(a, mp.getOrDefault(a, 0) + 1);

        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (!r.containsKey(entry.getValue())) {
                r.put(entry.getValue(), new ArrayList<>());
            }
            r.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<Integer, List<Character>> entry : r.entrySet()) {
            int freq = entry.getKey();
            List<Character> chars = entry.getValue();
            for (char c : chars) {
                for (int i = 0; i < freq; i++) {
                    ss.append(c);
                }
            }
        }

        return ss.toString();
    }
}




