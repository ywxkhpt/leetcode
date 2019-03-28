package subsets;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) return res;
        helper(res,new ArrayList<Integer>(),S,0);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp,int[] S,int index){
        res.add(new ArrayList<Integer>(temp));
        for (int i=index;i<S.length;i++){
            temp.add(S[i]);
            helper(res,temp,S,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
