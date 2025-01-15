class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        // Create a set of words from the list so that the lookup cost in the set becomes O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        // Initialize the lookup table
        boolean[] dp = new boolean[n + 1];

        // Set the first element to true as it represents the empty string
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Checking if the substring from j to i is present in the wordSet and dp[j] is true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // If a substring is found, no need to check further smaller substrings
                    break;
                }
            }
        }

        // Return the last element of dp array
        return dp[n];
    }
}
