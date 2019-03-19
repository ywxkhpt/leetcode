package container_with_most_water;

//双指针 每次舍弃高度比较低的木板 直到左右相遇
public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right){
            res = Math.max(res,(right - left) * Math.min(height[right],height[left]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
