package four_sum;

//O(n^3) 先固定一个数转化为3sum
//先对数组进行排序 然后固定一个数 采用双指针
//如果 sum-num[i] == num[j] + num [k] 找到了一组 记得去重
//如果 sum-num[i] < num[j] + num [k] k--;
//如果 sum-num[i] > num[j] + num [k] j++;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length - 3;i++){
            if(i >0 && nums[i] == nums[i-1]) continue;//去重
            for(int j = i+1;j<nums.length - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;//去重
                int low = j+1;
                int high = nums.length -1;
                while (low<high){
                    if (nums[low] + nums[high] + nums[i] + nums[j] == target){
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[low],nums[high])));
                        while (low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while (low < high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if (nums[low] + nums[high] + nums[i] + nums[j] < target){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
