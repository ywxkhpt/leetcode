package substring_with_concatenation_of_all_words;

//找到S中连续出现的L的位置
import java.util.*;
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S == null || L == null) return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String s:L){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        int m = L[0].length();
        int n = L.length;
        for(int i=0;i<=S.length() - m*n;i++){
            int j = i;
            int k = n;
            HashMap<String,Integer> copy = new HashMap<String,Integer>(map);
            while(k > 0){
                String temp = S.substring(j,j+m);
                if(!copy.containsKey(temp) || copy.get(temp) < 1){
                    break;
                }else{
                    copy.put(temp,copy.get(temp)-1);
                    j=j+m;
                    k--;
                }
            }
            if(k == 0) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] L = {"a"};
        Solution solution = new Solution();
        solution.findSubstring("a",L);
    }
}
