package Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public static int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,4,4,5,1,1,1,2,2};
        findMin(nums);
    }
}
