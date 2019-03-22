package single_number_ii;

//数组中的所有的数的对应位相加 然后对3取余 出现3次的取余之后为0 出现一次的为1
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1<<i;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & mask) != 0) {
                    sum ++;
                }
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
