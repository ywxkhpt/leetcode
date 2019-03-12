package divide_two_integers;

//注：考虑溢出，当被除数为-2^31，除数为-1，商为2^31，会溢出 需要转成long
//不能一个一个相减，需要不断倍增
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        long lDividend = Math.abs((long) dividend);//need to convert to long first, then take the absolute value
        long lDivisor = Math.abs((long) divisor);//corner case Integer.MIN_VALUE
        int sign = (dividend ^ divisor) >> 31;
        long ans= 0;
        while(lDividend >= lDivisor){
            long curr = 1;
            long tempDivisor = lDivisor;
            while(lDividend >= tempDivisor){
                if(lDividend < tempDivisor + tempDivisor) break; //do not double if the next divisor is larger than dividend
                curr = curr + curr;
                tempDivisor = tempDivisor + tempDivisor;
            }
            lDividend -= tempDivisor;
            ans += curr;
        }
        if(sign == -1) ans*= -1;
        if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)ans;
    }
}
