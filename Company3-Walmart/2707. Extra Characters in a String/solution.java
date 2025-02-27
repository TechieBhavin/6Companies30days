// class Solution {
//     public int minExtraChar(String s, String[] dictionary) {
//         int[] dp = new int[51]; // Initialize an array to store the minimum extra characters.
//         int n = s.length();

//         for (int i = n - 1; i >= 0; --i) {
//             dp[i] = 1 + dp[i + 1]; // Initialize with one extra character.

//             for (String w : dictionary) {
//                 if (i + w.length() <= n && s.substring(i, i + w.length()).equals(w)) {
//                     dp[i] = Math.min(dp[i], dp[i + w.length()]); // Update if a word in the dictionary is found.
//                 }
//             }
//         }

//         return dp[0]; // Return the minimum extra characters for the entire string.
//     }
// }
import java.util.Arrays;

class Solution {
    private int[] dp = new int[51]; // Initialize dp array with 0 values

    public int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1); // Initialize dp array with -1 values
        return minExtraCharHelper(s, dictionary, 0);
    }

    private int minExtraCharHelper(String s, String[] dictionary, int i) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] == -1) {
            dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1); // Initialize with one extra character

            for (String w : dictionary) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length())); // Update if a word in the dictionary is found
                }
            }
        }

        return dp[i]; // Return the minimum extra characters starting from position i
    }
}
