package permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;

//递归和回溯
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        boolean[] isUsed =  new boolean[num.length];
        helper(res,new ArrayList<Integer>(),num,isUsed);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,int[] num,boolean[] isUsed){
        if (temp.size() == num.length) res.add(new ArrayList<Integer>(temp));
        for (int i=0;i<num.length;i++){
            if (isUsed[i] || (i >0 && num[i] == num[i-1] && !isUsed[i-1])) continue;
            isUsed[i] = true;
            temp.add(num[i]);
            helper(res,temp,num,isUsed);
            temp.remove(temp.size()-1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1};
        Solution solution = new Solution();
        solution.permuteUnique(num);
    }
}
