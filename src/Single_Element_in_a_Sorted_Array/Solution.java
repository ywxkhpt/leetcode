package Single_Element_in_a_Sorted_Array;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(mid % 2 == 1) mid--;//保证从偶数索引开始
            if(nums[mid] != nums[mid+1]){
                high = mid;
            }else{
                low = mid + 2;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution solution = new Solution();
        solution.singleNonDuplicate(nums);
    }
}
