package Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = lower_bound(nums,target);
        int high = upper_bound(nums,target);
        if(nums[low] != target) return new int[]{-1,-1};
        return new int[]{low,high-1};
    }

    private int lower_bound(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private int upper_bound(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution solution = new Solution();
        solution.searchRange(nums,1);
    }
}
