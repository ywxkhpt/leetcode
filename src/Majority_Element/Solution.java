package Majority_Element;
//摩尔投票法
//如果计数为零则重新选定投票者
//成对的从数组中删除元素 遍历整个数组 返回计数大于零的候选者
public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, majority = nums[0];
        for (int num : nums) {
            if (cnt == 0){
                majority = num;
                cnt++;
            }else if (majority == num){
                cnt++;
            }else {
                cnt--;
            }
        }
        return majority;
    }
}
