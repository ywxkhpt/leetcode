package wildcard_matching;

//1. if p.charAt(j) == '*' dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i-1][j-1]
//                                      '*'表示空    '*'表示多个     '*'表示一个
//2. if p.charAt(j) != '*' dp[i][j] = (s.charAt(i) == s.charAt(j) || p.charAt(j) == '?') && dp[i-1][j-1]
//
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; //初始化
        for(int i=0;i<p.length();i++){  //s = ""  p = "***" 对这种情况初始化
            if(p.charAt(i) == '*'){
                dp[0][i+1] = dp[0][i];
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i][j];
                }else{
                    dp[i+1][j+1] = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
