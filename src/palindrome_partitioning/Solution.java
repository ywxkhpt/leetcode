package palindrome_partitioning;

//将字符串分割为全是回文的子字符串
//采用递归加回溯
import java.util.*;
public class Solution {
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    ArrayList<String> temp = new ArrayList<String>();
    public ArrayList<ArrayList<String>> partition(String s) {
        if(s==null || s.length() == 0) return res;
        backTrace(s,0);
        return res;
    }

    private void backTrace(String s,int i){
        if(i >= s.length()){//递归基
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int loc = i;loc < s.length();loc++){
            if (isPalindrome(s,i,loc)){
                if(loc == i){
                    temp.add(String.valueOf(s.charAt(i)));
                }else{
                    temp.add(s.substring(i,loc+1));
                }
                backTrace(s,loc+1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private  boolean isPalindrome(String s,int i,int j){//判断是否回文
        if(i == j) return true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
