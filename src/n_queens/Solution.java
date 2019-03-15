package n_queens;

import java.util.*;
public class Solution {
    ArrayList<String[]> res = new ArrayList<String[]>();

    public ArrayList<String[]> solveNQueens(int n) {
        if(n <= 0) return res;
        boolean[] col = new boolean[n];//列
        boolean[] d1 = new boolean[2*n];//左对角线 \
        boolean[] d2 = new boolean[2*n];//右对角线 /
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//存储行列值
        helper(col,d1,d2,0,n,map);
        return res;
    }

    //k记录放到第几一行
    private void helper(boolean[] col,boolean[] d1,boolean[] d2,int k,int n,HashMap<Integer,Integer> map){
        if(k == n){//递归基
            String[] string = toResult(n,map);
            res.add(string);
            return;
        }

        for(int i=0;i<n;i++){
            int leftLoc = i - k + n; //左对角线的位置
            int rightLoc = i + k; //右对角线的位置
            if(col[i] || d1[leftLoc] || d2[rightLoc]) continue;
            col[i] = true;
            d1[leftLoc] = true;
            d2[rightLoc] = true;
            map.put(k,i);
            helper(col,d1,d2,k+1,n,map);
            col[i] = false;
            d1[leftLoc] = false;
            d2[rightLoc] = false;
            map.remove(k);
        }
    }

    private String[] toResult(int n,HashMap<Integer,Integer> map){
        String[] res = new String[n];
        for(int i=0;i<n;i++){
            int col = map.get(i);
            StringBuilder builder = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j == col){
                    builder.append("Q");
                }else{
                    builder.append(".");
                }
            }
            res[i] = builder.toString();
        }
        return res;
    }
}
