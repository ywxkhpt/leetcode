package word_break_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution {

    HashMap<Integer,ArrayList<String>> map = new HashMap<>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        return dfs(s,dict,0);
    }

    public ArrayList<String> dfs(String s, Set<String> dict,int start){
        if (map.containsKey(start)) return map.get(start);

        ArrayList<String> res = new ArrayList<>();
        if (start == s.length()){//到达单词的末尾
            res.add("");
        }
        for (int end = start+1;end<=s.length();end++){
            if (dict.contains(s.substring(start,end))){
                ArrayList<String> list = dfs(s, dict, end);
                for (String temp:list){
                    res.add(s.substring(start,end)+ (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start,res);
        return res;
    }

}
