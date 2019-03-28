package edit_distance;
//动态规划
//dp[i][j]表示word1.subString(0,i)到word2.subString(0,j)的最小编辑距离
//状态转移方程
//1. word1.charAt(i-1) == word2.charAt(j-1) dp[i][j] = dp[i-1][j-1]
//2. word1.charAt(i-1) != word2.charAt(j-1)
//  1. dp[i][j] = dp[i][j-1] + 1  插入
//  2. dp[i][j] = dp[i-1][j-1] + 1  替换
//  3. dp[i][j] = dp[i-1][j] + 1  删除
//初始化
//      a   b   c   d
//  0   1   2   3   4
//a 1
//e 2
//f 3
public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i=0;i<=length2;i++){//初始化第一行
            dp[0][i] = i;
        }
        for (int i=0;i<length1;i++){//初始化第一列
            dp[i][0] = i;
        }

        for (int i=1;i<=length1;i++){
            for (int j=1;j<=length2;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minDistance("","a");
    }
}
