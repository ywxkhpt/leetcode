package longest_palindromic_substring;

//动态规划 和 中心扩散两种方法
public class Solution {
    //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
    //从上到下 从左到右 按列
    //i表示字符串的左边界 j表示字符串的右边界
    public String longestPalindrome(String s){
        if(s==null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String res = "";
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                //aa 和 aba 只需要前边相等就可以
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j-i <= 2) || dp[i+1][j-1]);
                if(dp[i][j]){
                    if(j-i+1 > max){
                        max = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    String res = "";
    public String longestPalindrome2(String s){
        if (s ==null || s.length() == 0) return s;
        for (int i=0;i<s.length();i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return res;
    }

    private void helper(String s,int left,int right){
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if (cur.length() > res.length()){
            res = cur;
        }
    }
}
