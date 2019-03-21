package string_to_integer_atoi;

//1.考虑str前后有空格
//2.考虑str有正负号
//3.考虑出现不合法的字符
//4.考虑越界
public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int start =0;
        if(firstChar == '+'){
            sign = 1;
            start++;
        }
        if(firstChar == '-'){
            sign = -1;
            start++;
        }
        long res = 0;
        for(int i=start;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int)(sign * res);
            }
            res = res * 10 + (str.charAt(i) - '0');
            if(sign == 1){
                if(sign*res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            if(sign == -1){
                if(sign*res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)(sign * res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.atoi("2147483648"));
    }
}
