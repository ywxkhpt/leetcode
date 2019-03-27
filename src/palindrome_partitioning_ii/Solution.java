package palindrome_partitioning_ii;
//判断一个字符串最少切分多少次生成的子串是回文串
//动态规划求解
//dp[i][j] 记录s.subString(i,j)是否是回文
//cut[i] 记录s.subString(0,i)最少切分多少次生成的子串是回文串
//cut[i] = Math.min(cut[j]+1,cut[i])
//a   b   a   |   c  c
//        j  i
//        j-1  |  [j, i] is palindrome
//        cut(j-1) +  1
public class Solution {
    public int minCut(String s) {
        int[] cut = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            int min = i;
            for (int j=0;j<=i;j++){
                if (s.charAt(i) == s.charAt(j) && (j+1 > i-1 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min,cut[j-1]+1);//当j==0的时候说明s.subString(0,i)是回文 此时不需要切分
                }
            }
            cut[i] = min;
        }
        return cut[s.length()-1];
    }
}
