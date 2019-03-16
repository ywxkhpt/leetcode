package best_time_to_buy_and_sell_stock_ii;

//可以多次买入卖出
//同一天可以先卖出再买入
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] - prices[i-1] > 0) max += prices[i] - prices[i-1];
        }
        return max;
    }
}
