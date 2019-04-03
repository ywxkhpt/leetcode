package Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

//动态规划
//先按照起始坐标排序
//dp[i]表示第i个最长的链
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        for (int i=1;i<pairs.length;i++){
            for (int j=0;j<i;j++){
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp){
            res = Math.max(res,i);
        }
        return res;
    }
}
