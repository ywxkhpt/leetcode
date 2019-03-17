package plus_one;

//需要考虑溢出的情况
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int length = digits.length - 1;
        for(int i=length; i>=0 ;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {1};
        Solution solution = new Solution();
        solution.plusOne(digits);
    }
}
