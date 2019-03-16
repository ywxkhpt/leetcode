package best_time_to_buy_and_sell_stock;

//只能进行一次交易（买进 买出）
//动态规划 dp[]
//min[i]表示到0-i处买入的最小值
//profit[i]表示到i处卖出时获利最大值
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int length = prices.length;
        int min = Integer.MAX_VALUE;
        int[] profit = new int[length];
        profit[0] = 0;
        int max = 0;
        for(int i=1;i<length;i++){
            if(min > prices[i-1]){min = prices[i-1];}
            profit[i] = prices[i] - min;
            max = Math.max(max,profit[i]);
        }
        return max;
    }
}
