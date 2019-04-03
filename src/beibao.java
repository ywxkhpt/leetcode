//0-1背包问题 完全背包 多重背包
//dp[i][j] 表示前i件物品 总重不超过j的时候 最大的价值
// 0-1背包的分类标准是取或者不取当前物品
// 完全背包的分类标准是 取0 1 2 ...个物品
// 多重背包的分类标准是 取0 1 2 ... k个物品
public class beibao {
    public int problem1(int W, int N, int[] weights, int[] values){
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public int problem2(){
        //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w] + v);
        //经过等式变形可以得到上面递推公式
        return 0;
    }

    public int  problem3(){
        //dp[i][j] = Math.max(dp[i - 1][j - k * ci] + k * vi), 0<= k <= ni;
        return 0;
    }
}
