class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Track frequencies to handle removing elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        int start = 0, end = 0;
        
        // Process first window
        while (end < k) {
            pq.offer(arr[end]);
            frequencyMap.put(arr[end], frequencyMap.getOrDefault(arr[end], 0) + 1);
            end++;
        }
        
        // Add max of first window
        ans.add(pq.peek());
        
        // Slide the window
        while (end < arr.length) {
            // Add new element
            pq.offer(arr[end]);
            frequencyMap.put(arr[end], frequencyMap.getOrDefault(arr[end], 0) + 1);
            
            // Remove start element from frequency map
            frequencyMap.put(arr[start], frequencyMap.get(arr[start]) - 1);
            
            // Remove elements from priority queue that are no longer in the window
            while (!pq.isEmpty() && frequencyMap.get(pq.peek()) == 0) {
                pq.poll();
            }
            
            // Add max of current window
            ans.add(pq.peek());
            
            // Move window
            start++;
            end++;
        }
        
        return ans;
    }
}
