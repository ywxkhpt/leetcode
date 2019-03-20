package anagrams;

import java.util.ArrayList;
import java.util.HashMap;

//将字符串转换为字符数组 对字符数组排序 并使用HashMap进行映射
//排序可以采用快排或者计数排序 计数排序时间复杂度较低
public class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        int[] count = new int[26];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                count[chars[i] - 'a']++;
            }
            String s = "";
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    s += String.valueOf(chars[i]) + String.valueOf((char) (chars[i] + 'a'));
                }
            }
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
