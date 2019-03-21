package longest_substring_without_repeating_characters;

//类似滑动窗口
import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int res = 0;
        int j = -1;//记录窗口左边的位置
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > j){//在窗口内的时候更新窗口的左边界
                j = map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("wlrbbwqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
    }
}
