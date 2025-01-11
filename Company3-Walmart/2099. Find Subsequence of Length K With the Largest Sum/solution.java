/**
The algorithm is based on Priority-Queue + Sorting.
- Store the (index, value) of k elements in heap.
- For all other elements in the array, check if the element
is greater than the top of the heap.
- If yes, then remove top element and add the current element.
- At the end, collect all the indexes in heap.
- Sort the indexes.
- Replace indexes with their elements.
- Return the result. */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // min-heap based on 1st index i.e. value.
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int i=0;i<k;i++) {
            // adding (index,value) to the heap.
            queue.offer(new int[]{i, nums[i]});
        }
        // comparing other elements with min-heap top element.
        for(int i=k;i<nums.length;i++) {
            if(queue.peek()[1] < nums[i]) {
                queue.poll();
                queue.offer(new int[]{i, nums[i]});
            }
        }
        // retrieving heap indexes.
        int[] res = new int[k];
        int index = 0;
        while(!queue.isEmpty()) {
            res[index++] = queue.poll()[0];
        }
        // sorting the indexes.
        Arrays.sort(res);
        
        // forming the answer array.
        for(int i=0;i<k;i++) {
            res[i] = nums[res[i]];
        }
        return res;
    }
}
