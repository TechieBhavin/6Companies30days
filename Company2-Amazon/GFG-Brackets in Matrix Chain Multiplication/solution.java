class Solution {
    static String matrixChainOrder(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        char[][] order = new char[n][26];

        // for(int [] temp : dp) {
        //     Arrays.fill(temp, -1);
        // }

        // getMinimumValue(arr, 1, n - 1, dp, order);
        
        for(int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for(int i = n - 1; i >= 1; i--) {
            for(int j = i + 1; j < n; j++) {
                int minRes = (int) 1e9;
                for(int k = i; k < j; k++) {
                    int currRes = arr[i - 1] * arr[j] * arr[k] + dp[i][k] + dp[k + 1][j];
                    if(minRes > currRes) {
                        minRes = currRes;
                        order[i][j] = (char) ('A' + k - 1);
                    }
                }
                dp[i][j] = minRes;
            }
        }
        
        String resulString = constructString(order, 1, n - 1);
        return resulString;
    }
    
    static int getMinimumValue(int[] arr, int i, int j, int[][] dp, char[][] order) {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int minRes = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int currRes = arr[i - 1] * arr[j] * arr[k] + getMinimumValue(arr, i, k, dp, order) + getMinimumValue(arr, k + 1, j, dp, order);
            if(currRes < minRes) {
                minRes = currRes;
                order[i][j] = (char) ('A' + k - 1);
            }
        }
        return dp[i][j] = minRes;
    }
    
    static String constructString(char[][] order, int i, int j) {
        if(i == j) return "" + (char)('A' + i - 1);

        String result = "";
        result += '(' + constructString(order, i, order[i][j] - 'A' + 1) + constructString(order, order[i][j] - 'A' + 2, j) + ')';
        return result;
    }

}
