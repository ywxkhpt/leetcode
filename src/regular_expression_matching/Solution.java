package regular_expression_matching;

//1. if s[i] == p [j]  dp[i][j] = dp[i-1][j-1] 对应相等
//2. if p[j] == '.' dp[i][j] = dp[i-1][j-1] '.'可以匹配任意单个字符
//3. if p[j] == '*'
//        (1). p[j-1] != s[i] dp[i][j] = dp[i][j-2] '*'此时代表一个或多个都不能继续进行匹配 '*'表示空 需要看j-2的情况
//        (2)  p[j-1] == s[i] || p[j-1] == '.' 又可以分为以下三种情况
//            1. '*'表示单个 dp[i][j] == dp[i][j-1]
//            2. '*'表示多个 dp[i][j] == dp[i-1][j]  将s[i]和前面的进行合并
//            3. '*'表示空  dp[i][j] == dp[i][j-2]
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //是否要判断越界 可能第一个默认不为'*'
        for(int i = 0;i < p.length();i++){ //对s为空 p不为空的情况进行初始化 因为后面计算的时候不能初始化第一行
            if(p.charAt(i) == '*' && dp[0][i-1]){ // s=""  p="a*b*c*" a*,b*,c*都是为空
                dp[0][i+1] = dp[0][i-1];
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i) == p.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '.'){
                    dp[i+1][j+1] =  dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
