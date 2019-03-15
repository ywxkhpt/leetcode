package combination_sum;

//元素可以使用多次
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return lists;
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(lists,temp,num,target,0);
        return lists;
    }

    private void helper(ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> temp,int[] num, int target,int start){
        if(target < 0){
            return;
        }else if(target == 0){
            lists.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = start;i < num.length;i++){
                temp.add(num[i]);
                helper(lists,temp,num,target-num[i],i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
