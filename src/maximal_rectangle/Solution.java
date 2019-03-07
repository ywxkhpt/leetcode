package maximal_rectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //参照求直方图的最大面积
    //将本问题转化为求直方图的最大面积
    //对每一行如果当前为0 则高度置为0 如果为1 高度为上一行的高度加1
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int max = 0;
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j] = height[j] + 1;
                }
            }
            int res = largestRectangleArea(height);
            max = Math.max(max,res);
        }
        return max;
    }
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
}
