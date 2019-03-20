package length_of_last_word;

//从后往前
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int length = s.length()-1;
        int res = 0;
        boolean flag = false;
        for(int i=length;i>=0;i--){
            if(s.charAt(i) != ' '){
                res++;
                flag = true;
            }
            if(flag && s.charAt(i) == ' '){
                return res;
            }
        }
        return res;
    }
}
