package distinct_subsequences;

//动态规划
//dp[i][j] 表示S[1:j]子序列中 含有T[1:i]子序列的个数
//转移方程 if(S[j] == t[i]){
//            dp[i][j] = dp[i-1][j-1] + dp[i][j-1] //即使用当前字符匹配或跳过当前字符
//        }else{
//            dp[i][j] = dp[i][j-1]
//        }
//
public class Solution {
    public int numDistinct(String S, String T) {
        int ls = S.length();
        int lt = T.length();
        int[][] dp = new int[lt+1][ls+1];
        for(int i=0;i<=ls;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<=lt;i++){
            for(int j=1;j<=ls;j++){
                if(S.charAt(j-1) == T.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[lt][ls];
    }
}
