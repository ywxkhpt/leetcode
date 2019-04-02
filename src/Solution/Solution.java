package Solution;

public class Solution {
    public static int solution(String s){
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int temp = chars[0];
        for (int i=1;i<length;i++){
            if (i < length && temp == chars[i]){
                chars[i-1] = '*';
                chars[i] = '*';
            }else {
                temp = chars[i];
            }
        }
        int count = 0;
        char pre = '*';
        for (int i=0;i<chars.length;i++){
            if (chars[i] != '*' && pre == '*'){
                count++;
            }
            pre = chars[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("abbcccadhhh"));
    }
}
