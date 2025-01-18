class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int trim = queries[i][1];
            int k = queries[i][0];

            TreeMap<String, List<Integer>> map = new TreeMap<>();

            for (int j = 0; j < nums.length; j++) {
                String trimValue = nums[j].substring(nums[j].length() - trim);
                
                if (!map.containsKey(trimValue)) {
                    map.put(trimValue, new ArrayList<>());
                }
                
                map.get(trimValue).add(j);
            }

            int count = 0;
            int smallestBasedOnK = -1;

            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                List<Integer> indices = entry.getValue();
                Collections.sort(indices);
                
                if (count + indices.size() >= k) {
                    smallestBasedOnK = indices.get(k - count - 1);
                    break;
                }
                count += indices.size();
            }

            ans[i] = smallestBasedOnK;
        }
        return ans;
    }
}
