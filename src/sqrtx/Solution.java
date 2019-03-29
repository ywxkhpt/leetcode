package sqrtx;
//跳出循环的时候 high < low 最终结果存储在high上
public class Solution {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        int low = 1,high = x;
        while (low <= high){
            int mid = (high - low) /2 + low;//mid * mid可能会超出int范围
            if (mid > x / mid){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }
}
