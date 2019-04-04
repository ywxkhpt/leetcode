package Partition_Equal_Subset_Sum;

//dp[i]表示当前数组中一些数的和是否等于sum
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i: nums){
            sum += i;
        }
        if (sum % 2 != 0) return false;
        sum = sum /2;
        boolean[] dp = new boolean[sum + 1];
        for (int num : nums){
            for (int j=sum;j>=num;j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
