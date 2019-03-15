package generate_parentheses;

//递归回溯
import java.util.*;
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n == 0) return res;
        helper(res,"",n,n);
        return res;
    }
    //left 代表剩余的'('的个数 right代表剩余的')'的个数
    private void helper(ArrayList<String> res,String s,int left,int right){
        if(left > right) return; //(()))这种情况下后面不可能合法
        if(left == 0 && right == 0) res.add(s);
        if(left > 0) helper(res,s+"(",left -1,right);
        if(right >0) helper(res,s+")",left,right-1);
    }
}