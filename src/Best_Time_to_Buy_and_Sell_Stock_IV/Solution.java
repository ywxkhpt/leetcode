package Best_Time_to_Buy_and_Sell_Stock_IV;

//动态规划 交易次数等于卖出次数 需要先买入再卖出 同一天可以先卖出再买入 同一时间最多只能持有一只股票
//dp[i][j] i表示进行的交易次数 j表示天数 从0-(prices.length-1)天
//               |  dp[i][j-1]  表示第j天不进行交易
//dp[i][j] = max |
//               |  dp[i-1][m] + prices[j] - prices[m]   m = 0,1,..,j-1 最后一次卖出在第j天进行 最后一次买入在第m天进行
//可以令maxDiff = dp[i-1][m] - prices[m] 减少重复计算 进行优化
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        //第一行第一列初始化全是0
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < prices.length; j++) {
                int maxValue = 0;
                for (int m=0;m<j;m++){
                    maxValue = Math.max(maxValue,dp[i-1][m] + prices[j] - prices[m]);
                }
                dp[i][j] = Math.max(dp[i][j-1],maxValue);
            }
        }
        return dp[k][prices.length -1];
    }

    public int fastmaxProfit(int k, int[] prices) { //进行了优化
        if (k <= 0 || prices == null || prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        //第一行第一列初始化全是0
        for (int i = 1; i < k + 1; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff,dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][prices.length -1];
    }
}
