package Largest_Rectangle_in_Histogram;

import java.util.Arrays;
import java.util.Stack;

//用栈来存储递增序列
//当遇到比栈顶元素小的元素的时候 栈中元素出栈 并计算面积 并更新最大面积
//需要在原数组最后添加一个元素0，使得出现递增序列的时候可以计算面积
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height,height.length + 1);//最后添加一个0
        int res = 0;//记录最大面积
        int i = 0;//起始位置
        while( i < h.length){
            if (stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int height_now = h[stack.pop()]; //计算面积时 现在的高度
                int width_now = stack.isEmpty() ? i : (i - stack.peek() - 1); //现在的宽度
                res = Math.max(res,height_now * width_now);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        Solution solution = new Solution();
        solution.largestRectangleArea(height);
    }
}
