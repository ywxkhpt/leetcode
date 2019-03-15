package letter_combinations_of_a_phone_number;

import java.util.*;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Character> temp = new ArrayList<Character>();
        if(digits == null || digits.length() == 0){
            res.add("");
            return res;
        }
        String[] map = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits,0,res,temp,map);
        return res;
    }

    private void dfs(String digits,int loc,ArrayList<String> res,ArrayList<Character> temp,String[] map){
        if(loc == digits.length()){
            StringBuilder builder = new StringBuilder();
            for(char c:temp){
                builder.append(c);
            }
            res.add(builder.toString());
            return;
        }
        String s = map[digits.charAt(loc)-'0'];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            temp.add(c);
            dfs(digits,loc+1,res,temp,map);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("2");
    }
}
