package permutation_sequence;

import java.util.ArrayList;

//求全排列的第k个数
//可以使用递归加回溯 可能会时间超时
//1 {2,3,4}
//2 {1,3,4}
//3 {1,2,4}
//4 {1,2,3}
//1 2 6 24
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();//记录还有哪些数未能够使用
        for (int i=1;i<=n;i++){
            res.add(i);
        }
        int[] fact = new int[n];//记录排列数
        fact[0] = 1;
        for (int i=1;i<n;i++){
            fact[i] = i * fact[i-1];
        }
        k = k-1;
        StringBuilder builder = new StringBuilder();
        for (int i=n;i>0;i--){
            int index=k/fact[i-1];
            k = k%fact[i-1];
            builder.append(res.get(index));//得到第i位的数
            res.remove(index);//移除已经使用的数
        }
        return builder.toString();
    }
}
