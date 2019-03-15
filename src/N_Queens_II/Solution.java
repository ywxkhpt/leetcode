package N_Queens_II;

//递归加回溯
//需要 一个列数组 一个左对角线数组 一个有对角线数组 记录是否有皇后存在
//摆放的时候一行一行摆放 然后需要验证 列 对角线上是否有皇后
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0) return count;
        boolean[] col = new boolean[n];//列
        boolean[] d1 = new boolean[2*n];//左对角线 \
        boolean[] d2 = new boolean[2*n];//右对角线 /
        helper(col,d1,d2,0,n);
        return count;
    }
    //k记录放到第几一行
    private void helper(boolean[] col,boolean[] d1,boolean[] d2,int k,int n){
        if(k == n){//递归基
            count++;
            return;
        }

        for(int i=0;i<n;i++){
            int leftLoc = i - k + n; //左对角线的位置
            int rightLoc = i + k; //右对角线的位置
            if(col[i] || d1[leftLoc] || d2[rightLoc]) continue;
            col[i] = true;
            d1[leftLoc] = true;
            d2[rightLoc] = true;
            helper(col,d1,d2,k+1,n);
            col[i] = false;
            d1[leftLoc] = false;
            d2[rightLoc] = false;
        }
    }
}
