package trapping_rain_water;

//需要一个栈记录下标 当栈顶的元素小于A[i]位置的元素的时候 需要弹栈并计算这一段的储水量
import java.util.*;
public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, maxNow = 0;
        int i = 0;
        while(i < A.length){
            if(stack.isEmpty() || A[stack.peek()] >= A[i]){
                stack.push(i++);
            }else{
                int bot = stack.pop();//底
                maxNow = stack.isEmpty() ? 0: (Math.min(A[stack.peek()],A[i]) - A[bot]) * (i - stack.peek() - 1);
                max += maxNow;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        solution.trap(A);
    }
}
