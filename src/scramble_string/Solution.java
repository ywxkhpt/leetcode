package scramble_string;

//dp较难 递归暴力求解 到叶子结点对应的字母相等
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;
        int[] letters = new int[26];//判断两个字符串中的字母是否完全一样
        int len = s1.length();
        for (int i=0;i<len;i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i=0;i<26;i++){
            if (letters[i] != 0) return false;
        }
        for (int i=1;i<len;i++){
            if (isScramble(s1.substring(0,i),s2.substring(0,i))
                && isScramble(s1.substring(i),s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i),s2.substring(len-i)) &&
                isScramble(s1.substring(i),s2.substring(0,len-i))) return true;
        }
        return false;
    }
}
