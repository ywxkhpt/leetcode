package Combination_Sum_IV;

import java.util.Arrays;

//动态规划
//dp[i]表示 target为i的时候 组合的个数
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        for (int i=1;i<=target;i++){
            for (int j = 0;nums[j] <= i && j<nums.length;j++){
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
