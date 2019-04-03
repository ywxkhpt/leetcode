package Wiggle_Subsequence;

//动态规划
//down记录了到i位置的时候最后一段是下降的最长序列
//up记录了到i位置的时候最后一段是上升的最长序列
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int down = 1;
        int up = 1;
        for (int i=1;i<nums.length;i++){
            if (nums[i] < nums[i-1]) down = up + 1;
            if (nums[i] > nums[i-1]) up = down + 1;
        }
        return Math.max(down,up);
    }
}
