package subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;

//递归回溯
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        helper(res,new ArrayList<Integer>(),0,num);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,int index,int[] num){
        res.add(new ArrayList<>(temp));
        for (int i=index;i<num.length;i++){
            if (i != index && num[i] == num[i-1]) continue;//去重
            temp.add(num[i]);
            helper(res,temp,i+1,num);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] num = {0};
        Solution solution = new Solution();
        solution.subsetsWithDup(num);
    }
}
