package valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.equals("")) return true;
        String lowS = s.toLowerCase();
        char[] chars = lowS.toCharArray();
        int length = chars.length;
        for(int i = 0, j = length - 1;i < j;){
            if(!Character.isAlphabetic(chars[i]) && !Character.isDigit(chars[i])){
                i++;
                continue;
            }
            if(!Character.isAlphabetic(chars[j]) && !Character.isDigit(chars[j])){
                j--;
                continue;
            }
            if(chars[i] != chars[j]){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
