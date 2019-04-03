package Perfect_Squares;

import java.util.Arrays;

//动态规划
//其中dp[i]表示正整数i能少能由多个完全平方数组成
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
