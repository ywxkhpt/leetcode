package maximum_subarray;

//dp[i] 表示以i结尾的子串的最大值
//当dp[i-1]小于0的时候 dp[i]等于本身
public class Solution {
    public int maxSubArray(int[] A) {
        int length = A.length;
        int[] dp = new int[length];
        dp[0] = A[0];
        int max = A[0];
        for(int i=1;i<length;i++){
            dp[i] = A[i] + (dp[i-1] < 0 ? 0 : dp[i-1]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}