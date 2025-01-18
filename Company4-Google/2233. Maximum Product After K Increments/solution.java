class Solution {
    public int maximumProduct(int[] nums, int k) {
                     
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        long product = 1;
        int mod = 1000000007;

        for (int x : nums) {
            priorityQueue.offer(x);
        }
		
        while (k-- > 0) {
            int i = priorityQueue.poll();
            priorityQueue.offer(i + 1);
        }

        while (!priorityQueue.isEmpty()) {
            product = product * priorityQueue.poll() % mod;
        }
        return (int) product;
    }
}
