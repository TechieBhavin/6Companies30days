class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        int[] buy = new int[k]; // buy[i]: min cost at (i + 1)-th time stock purchased
        int[] sell = new int[k]; // sell[i]: max revenue at (i + 1)-th time stock sold
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        
        for (int i : prices) {
            buy[0] = Math.max(buy[0], i * -1);
            sell[0] = Math.max(sell[0], buy[0] + i);
            for (int j = 1; j < k; j++) { // The i-th time buy & sell depens on the (i - 1)-th time buy & sell
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k - 1];
    }
}
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         return solve(0,1,prices,0,k);
//     }
//     int solve(int ind,int buy,int[] prices,int count,int k)
//     {
//         if(ind==prices.length)
//         return 0;
//         if(count==k)
//         return 0;
//         int profit=0;
//         if(buy==1 && count<k)
//         {
//             int op1=-prices[ind]+solve(ind+1,0,prices,count,k);
//             int op2=solve(ind+1,1,prices,count,k);
//             profit=Math.max(op1,op2);
//         }
//         else
//         {
//             int op1=prices[ind]+solve(ind+1,1,prices,count+1,k);
//             int op2=solve(ind+1,0,prices,count,k);
//             profit=Math.max(op1,op2);
//         }
//         return profit;
//     }
// }
