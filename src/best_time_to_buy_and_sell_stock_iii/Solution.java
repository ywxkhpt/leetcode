package best_time_to_buy_and_sell_stock_iii;
//动态规划求解
public class Solution {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0) return 0;
        int[][] dp = new int[2 + 1][prices.length];
        //第一行第一列初始化全是0
        for (int i = 1; i < 2 + 1; i++) {
            for (int j = 1; j < prices.length; j++) {
                int maxValue = 0;
                for (int m=0;m<j;m++){
                    maxValue = Math.max(maxValue,dp[i-1][m] + prices[j] - prices[m]);
                }
                dp[i][j] = Math.max(dp[i][j-1],maxValue);
            }
        }
        return dp[2][prices.length -1];
    }
}
